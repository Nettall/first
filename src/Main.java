import org.jetbrains.annotations.NotNull;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws Exception {
        int[] price = new int[]{5, 100, 20, 66, 13};
        int discount = 50;
        int offset = 1;
        int readLength = 3;
        int[] var5 = decryptData(price, discount, offset, readLength);
        int var6 = var5.length;

        for (int i : var5) {
            System.out.print("" + i + ", ");
        }

    }

    public static int @NotNull [] decryptData(int[] price,
                                              int discount,
                                              int offset,
                                              int readLength) throws Exception {
        if (discount > 0 && discount < 100 && readLength > 0) {
            if (offset >= 0 && readLength + offset <= price.length) {
                int[] array = new int[readLength];
                int y = 0;

                for(int i = offset; i < offset + readLength; ++i) {
                    if (price[i] <= 0) {
                        throw new Exception("price(" + price[i] + ")");
                    }

                    array[y] = (int)((float)price[i] - (float)price[i] / 100.0F * (float)discount);
                    ++y;
                }

                return array;
            } else {
                throw new Exception("offset is(" + offset + ") < 0 or offset + readLength = " + (offset + readLength) + " are out of range(" + price.length + ")");
            }
        } else {
            throw new Exception("discount range(" + discount + ") invalid or no readLength(" + readLength + ")");
        }
    }
}
