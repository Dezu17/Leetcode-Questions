import java.util.*;

public class App {
    public String simplifyPath(String path) {
        Stack<String> elements = new Stack<>();
        String currentString = "";
        for (int index = 0; index < path.length(); index++)
            if (path.charAt(index) == '/') {
                if (index > 0 && path.charAt(index - 1) != '/') {
                    if (currentString.equals("..") && !elements.isEmpty())
                        elements.pop();
                    else if (!currentString.equals(".") && !currentString.equals(".."))
                        elements.push(currentString);
                    currentString = "";
                }
            }
            else
                currentString += path.charAt(index);
        if (!elements.isEmpty()) {
            if (currentString.equals(".."))
                elements.pop();
            else if (!currentString.equals(".") && !currentString.equals(""))
                elements.push(currentString);
        }
        if (elements.isEmpty()) {
            if (currentString.equals(".") || currentString.equals(".."))
                return "/";
            else
                return "/" + currentString;
        }
        String result = "";
        while (!elements.isEmpty())
            result = "/" + elements.pop() +result;
        return result;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        System.out.println(app.simplifyPath("/home/"));
        System.out.println(app.simplifyPath("/home//foo/"));
        System.out.println(app.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(app.simplifyPath("/../"));
        System.out.println(app.simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(app.simplifyPath("/..."));
        System.out.println(app.simplifyPath("/."));
        System.out.println(app.simplifyPath("/.."));
    }
}
