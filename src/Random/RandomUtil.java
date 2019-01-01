package Random;

import java.util.Random;

public class RandomUtil {

    private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/";

    //仅由数字构成n位密码
    public static String randomPasswordByNum(int n) {
        char[] chars = new char[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            chars[i] = (char) ('0' + random.nextInt(10));
        return new String(chars);
    }

    private static char nextchar(Random random) {
        switch (random.nextInt(4)) {
            case 0:
                return (char) ('a' + random.nextInt(26));
            case 1:
                return (char) ('A' + random.nextInt(26));
            case 2:
                return (char) ('0' + random.nextInt(10));
            default:
                return SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length()));
        }
    }

    //由数字,大小写字母和特殊符号组成n位密码
    public static String randomPassword(int n) {
        char[] chars = new char[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            chars[i] = nextchar(random);
        return new String(chars);
    }

    private static int nextIndex(char[] chars, Random rnd) {
        int index =  rnd.nextInt(chars.length);
        while(chars[index]!=0)
            index = rnd.nextInt(chars.length);
        return index;
    }

    private static char nextSpeialChar(Random rnd) {
        return SPECIAL_CHARS.charAt(rnd.nextInt(SPECIAL_CHARS.length()));
    }

    private static char nextUpperLetter(Random rnd) {
        return (char) ('A' + rnd.nextInt(26));
    }

    private static char nextLowerLetter(Random rnd) {
        return (char) ('0' + rnd.nextInt(26));
    }

    private static char nextNumLetter(Random rnd) {
        return (char)('0'+rnd.nextInt(10));
    }

    //包含至少一个大写字母,一个小写字母,一个特殊字符,一个数字的n位密码
    public static String randomPasswordAtLeast(int n) {
        char[] chars = new char[n];
        Random rnd = new Random();
        chars[nextIndex(chars, rnd)] = nextSpeialChar(rnd);
        chars[nextIndex(chars, rnd)] = nextUpperLetter(rnd);
        chars[nextIndex(chars, rnd)] = nextLowerLetter(rnd);
        chars[nextIndex(chars, rnd)] = nextNumLetter(rnd);
        for(int i  = 0;i< n;i++) {
            if (chars[i]== 0 )
                chars[i]= nextchar(rnd);
        }
        return new String(chars);
    }

    private static void  swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }

    //随机洗牌
    public static void shuffle(int[] arr) {
        Random rnd = new Random();
        for(int i = 0;i < arr.length;i--)
            swap(arr, i -1, rnd.nextInt(i));//从后往前,逐个给每个数组位置重新赋值,随机挑选
    }
}
