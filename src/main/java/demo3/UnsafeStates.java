package demo3;

/**
 * <p>发布与逸出</p>
 * <p>如果有人窃取了你的密码并发布到新闻组上，
 * 那么你的信息将“逸出”:无论是否有人（或者尚未）恶意的使用这些个人信息，你的账户都已经不再安全了。
 * 发布一个引用同样会带来类似的风险</p>
 *
 * @author liuruichao
 * @date 15/6/9 下午4:55
 */
public class UnsafeStates {
    private String[] states = new String[]{
            "A", "B", "C"
    };

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafeStates unsafeStates = new UnsafeStates();
        String[] states = unsafeStates.getStates();
        System.out.println(" ---------------------- ");
        for (String str : states) {
            System.out.println(str);
        }
        states = new String[]{ "a", "b", "c" };
        System.out.println("-----------------------");
        for (String str : states) {
            System.out.println(str);
        }
    }
}
