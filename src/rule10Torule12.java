public class rule10Torule12 {
}
final class PhoneNumber implements Cloneable{
    public final short areaCode, prefix, lineNum;
    private int hashCode;

    public PhoneNumber(int areaCode, int prefix, int lineNum){
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg){
        if(val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short)val;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)obj;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode(){
        int result = hashCode;
        if(result == 0){
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }

    @Override
    public String toString(){
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    @Override
    public PhoneNumber clone() throws CloneNotSupportedException {
        return (PhoneNumber) super.clone();
    }
}