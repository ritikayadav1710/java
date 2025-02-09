class SingletonDoubleChecked {
    private static volatile SingletonDoubleChecked instance;

    private SingletonDoubleChecked() {
        System.out.println("Singleton instance created!");
    }

    public static SingletonDoubleChecked getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleChecked.class) {
                if (instance == null) {
                    instance = new SingletonDoubleChecked();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from SingletonDoubleChecked!");
    }

    public static void main(String[] args) {
        SingletonDoubleChecked singleton = SingletonDoubleChecked.getInstance();
        singleton.showMessage();
    }
}
