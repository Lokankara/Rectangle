package com.classwork.threads.io.lock;

abstract class Runner implements Runnable {
    Thread thread;
    Manager manager;

    Runner(String name, Manager manager) {
        this.manager = manager;
        this.thread = new Thread(this, name);
    }
}

class Counters extends Runner {
    public Counters(Manager manager) {
        super("Counter", manager);
    }

    @Override
    public void run() {
        for (String filename : Controller.filenames) {
            manager.count(new Resource(filename));
        }
    }
}

class Transformers extends Runner {
    public Transformers(Manager manager) {
        super("Transformer", manager);
    }

    @Override
    public void run() {
        for (int n = 0; n < Controller.filenames.size(); n++) {
            manager.transform();
        }
    }
}

class Transformer extends Runner {
    public Transformer(String filename, Manager manager) {
        super(filename, manager);
    }

    @Override
    public void run() {
        manager.transform();
    }
}

class Counter extends Runner {

    public Counter(String filename, Manager manager) {
        super(filename, manager);
    }

    @Override
    public void run() {
        manager.count(new Resource(thread.getName()));
    }
}
