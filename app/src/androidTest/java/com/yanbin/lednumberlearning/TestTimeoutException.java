package com.yanbin.lednumberlearning;

/**
 * Created by hungyanbin on 2015/5/16.
 */
public class TestTimeoutException extends RuntimeException {
    public TestTimeoutException() {
    }

    public TestTimeoutException(String detailMessage) {
        super(detailMessage);
    }

    public TestTimeoutException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public TestTimeoutException(Throwable throwable) {
        super(throwable);
    }
}
