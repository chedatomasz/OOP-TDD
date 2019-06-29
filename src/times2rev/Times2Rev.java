package times2rev;

public class Times2Rev {

    private static String FlipAndMultiply(String toFlip){
        if(toFlip.isEmpty())
            return "";
        else {
            long n = Long.parseLong(toFlip);
            n*= 2;
            StringBuilder result = new StringBuilder();
            result.append(n);
            String pre = result.reverse().toString();

            return Long.toString(Long.parseLong(pre));//remove leading zeros
        }
    }

    public static void main(String args[]){
        for (String arg : args) {
            System.out.println(FlipAndMultiply(arg));
        }
    }
}
