class ZeroEvenOdd {
    private final int n;
    private final Lock lock = new ReentrantLock();
    private final Condition zeroCondition = lock.newCondition();
    private final Condition numbCondition = lock.newCondition();
    private volatile boolean zeroTime = true;
    private final AtomicInteger curr = new AtomicInteger(1);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (curr.get() <= n) {
            try {
                lock.lock();
                while (!zeroTime) {
                    zeroCondition.await();
                }
                if (curr.get() <= n) {
                    printNumber.accept(0);
                }

                zeroTime = false;
                numbCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (curr.get() < n) {
            try {
                lock.lock();
                while (zeroTime || curr.get() % 2 != 0) {
                    numbCondition.await();
                }

                if (curr.get() <= n) {
                    printNumber.accept(curr.get());
                }

                curr.getAndIncrement();
                zeroTime = true;
                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (curr.get() <= n) {
            try {
                lock.lock();
                while (zeroTime || curr.get() % 2 == 0) {
                    numbCondition.await();
                }

                if (curr.get() <= n) {
                    printNumber.accept(curr.get());
                }
                curr.getAndIncrement();
                zeroTime = true;
                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}