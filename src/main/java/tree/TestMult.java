package tree;

/*
* 大数相乘
* */
public class TestMult {
    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        System.err.println("\nresult=" + getMult("99", "19"));
        System.err.println("\nresult=" + getMult("99", "99"));
        System.err.println("\nresult=" + getMult("123456789", "987654321"));
        System.err.println("\nresult=" + getMult("12345678987654321", "98765432123456789"));
        System.err.println("\ntake time: " + (System.currentTimeMillis() - timeStart));
    }

    public static String getMult(String bigIntA, String bigIntB) {
        int length = bigIntA.length() + bigIntB.length();
//        if (length < 10) { // Integer.MAX_VALUE = 2147483647;
//            return String.valueOf(Integer.valueOf(bigIntA) * Integer.valueOf(bigIntB));
//        }
        int[] result = new int[length]; // 保证长度足够容纳
        int[] aInts = reverse(toIntArray(bigIntA)); // 将大数拆分为数组，并反转 让个位从0开始
        int[] bInts = reverse(toIntArray(bigIntB)); // 也可以直接在转数组时顺便反转

        int maxLength = 0; // 保存中间结果的最大长度，便于后面累加的数组

        int[][] tempDatas = new int[bInts.length][]; // 储存中间已移位的结果，之后用于累加

        int extra = 0; // 进位
        for (int i = 0; i < bInts.length; i++) {
            int[] singleResult = new int[aInts.length]; // bigIntB中每一位与bigIntA的乘积
            extra = 0; // 进位清零，否则会影响后面结果
            for (int j = 0; j < aInts.length; j++) {
                int t = bInts[i] * aInts[j] + extra;
                singleResult[j] = t % 10;
                extra = t / 10;
            }
            if (extra > 0) { // 乘积最后进位，需要拓展一位存储extra
                int[] temp = new int[aInts.length + 1];
                for (int m = 0; m < singleResult.length; m++) {
                    temp[m] = singleResult[m];
                }
                temp[temp.length-1] = extra;
                singleResult = temp;
            }

            singleResult = insertZero(singleResult, i, true); // 移位加0

            print(singleResult); // 打印中间结果

            tempDatas[i] = singleResult; // 保存中间结果

            if (singleResult.length > maxLength) { // 获取位数最多的中间结果
                maxLength = singleResult.length;
            }
        }

        // 将中间结果从个位开始累加
        extra = 0;
        for (int k = 0; k < maxLength; k++) {
            int sum = extra;
            for (int[] datas : tempDatas) {
                if (k < datas.length) {
                    sum += datas[k];
                }
            }
            result[k] = sum % 10;
            extra = sum / 10;
        }
        if (extra > 0) { // 99*19
            result[maxLength] = extra; // 在初始化result[]时，已确认不会越界
        }

        // 将计算结果转为数字字符串
        StringBuilder builder = null;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] != 0 && builder == null) { // 去除高位多余的0
                builder = new StringBuilder();
            }
            if(builder != null) {
                builder.append(result[i]); // 会将结果反转，之前为便于计算，使下标为0的为个位
            }
        }

        return builder.toString();
    }

    /**
     * 将数字字符串拆解为int数组
     */
    static int[] toIntArray(String bigNumberStr) {
        char[] cs = bigNumberStr.toCharArray();
        int[] result = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            result[i] = cs[i] - '0';
        }
        return result;
    }

    /**
     * 在数组插入0做偏移，例如与百位相乘时，结果需要加两个0
     */
    static int[] insertZero(int[] datas, int count, boolean hasReversed) {
        if (count <= 0) {
            return datas;
        }
        int[] result = new int[datas.length + count];
        if (hasReversed) {
            for (int i = result.length - 1; i >= 0; i--) {
                int index = i - count;
                if (index >= 0) {
                    result[i] = datas[index];
                } else {
                    result[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < result.length - 1; i++) {
                if (i < datas.length) {
                    result[i] = datas[i];
                } else {
                    result[i] = 0;
                }
            }
        }
        return result;
    }

    /**
     * 数组反转
     */
    static int[] reverse(int[] datas) {
        for (int i = 0; i < datas.length / 2; i++) {
            int temp = datas[i];
            datas[i] = datas[datas.length - i - 1];
            datas[datas.length - i -1] = temp;
        }
        return datas;
    }

    /**
     * 打印数组
     */
    static void print(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + ", ");
        }
        System.out.println();
    }

}
