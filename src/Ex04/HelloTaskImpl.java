package Ex04;

import java.io.Serializable;

public class HelloTaskImpl implements HelloTask, Serializable {
    private static final long serialVersionUID = 1L;

    public String execute() {
        return "Hello World!";
    }
}
