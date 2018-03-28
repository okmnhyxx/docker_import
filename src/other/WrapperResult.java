package other;

/**
 * @author kexia.lu on 2017/10/23.
 */
public class WrapperResult<T> {

    private T result;

    public WrapperResult() {
    }

    public WrapperResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
