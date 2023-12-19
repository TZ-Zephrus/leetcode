package string;


//假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。
//
//
//
//示例 1：
//
//输入：path = "a.aef.qerf.bb"
//
//输出："a aef qerf bb"

public class lujingjiamiLCR122 {
    public static void main(String[] args) {
        String path = "abc def ghi";
        System.out.println(pathEncryption(path));
    }


    //用双指针法
    public static String pathEncryption(String path) {
        int count = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == ' ') {
                count++;
            }
        }
        char[] arr = new char[path.length()+count*2];
        int start = path.length()-1;
        int end = arr.length-1;
        while (start >= 0) {
            if (path.charAt(start) != ' ') {
                arr[end] = path.charAt(start);
                start--;
                end--;
            } else {
                arr[end--] = '0';
                arr[end--] = '2';
                arr[end] = '%';
                start--;
                end--;
            }
        }
        return new String(arr);
    }
}
