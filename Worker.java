public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;
    int mistake = 33;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }


    public void start() {
        for (int i = 0; i < 100; i++) {

            if (i + 1 == mistake) {
                errorCallback.onError("Выполнение задачи " + (i + 1) + " привело к ошибке");
            } else callback.onDone("Задача " + (i + 1) + " выполнена");


        }


    }


    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
}