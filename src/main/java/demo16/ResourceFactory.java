package demo16;


/**
 * 延时初始化resource
 *
 * @author liuruichao
 * @date 15/8/24 上午11:17
 */
public class ResourceFactory {
    private static class ResourceHolder {
        public static Resource resource = new Resource();
        static {
            System.out.println("ResourceHolder static init");
        }
    }

    public static Resource getInstance() {
        return ResourceHolder.resource;
    }

    private static class Resource {
        static {
            System.out.println("resource init");
        }

        public Resource() {
            System.out.println("init");
        }
    }

    public static void main(String[] args) {
        Resource resource = ResourceFactory.getInstance();
        resource = new Resource();
    }
}
