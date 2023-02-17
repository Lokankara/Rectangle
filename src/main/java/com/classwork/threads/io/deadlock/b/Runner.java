package com.classwork.threads.io.deadlock.b;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

abstract class Runner implements Runnable {

	protected Wrapper wrapper;

	public Runner(Wrapper wrapper) {
		super();
		this.wrapper = wrapper;
	}
}

class CounterTwoRunner extends Runner {

	public CounterTwoRunner(Wrapper wrapper) {
		super(wrapper);
		new Thread(this).start();
	}

	@Override
	public void run() {
		wrapper.countSpace();
	}
}

class TransformDuoRunner extends Runner{

    public TransformDuoRunner(Wrapper wrapper) {
		super(wrapper);
        new Thread(this).start();
    }

    @Override
    public void run() {
        this.wrapper.transform();
    }
}


class CounterMultiRunner extends Runner {

	public CounterMultiRunner(Wrapper wrapper) {
		super(wrapper);
		new Thread(this).start();
	}

	@Override
	public void run() {

		String line;

		synchronized (this.wrapper) {
			try (Scanner scannerFile = new Scanner(this.wrapper.getFile());) {

				while (scannerFile.hasNext()) {
					System.out.printf("CounterMultiRunner %s %s", Thread.currentThread().getName(),
							this.wrapper.getFile().getName());

					line = scannerFile.nextLine();
					this.wrapper.addToCounterSpace(line.length() - line.replaceAll(" ", "").length());
				}

			} catch (IOException ioe) {
				System.err.println(ioe);
			}
		}
	}
}

class TransformMultiRunner extends Runner{

    public TransformMultiRunner(Wrapper wrapper) {
		super(wrapper);
        new Thread(this).start();
    }

    @Override
    public void run() {

        synchronized (this.wrapper){

            try {
                String text = new String();
                Scanner scannerFile = new Scanner(this.wrapper.getFile());
                Scanner scannerLine ;
                String tempString;
                int amountOfSpace = this.wrapper.getCount();

                while (scannerFile.hasNext()){

                    scannerLine = new Scanner(scannerFile.nextLine());

                    while (scannerLine.hasNext()){

                        tempString = scannerLine.next().toLowerCase();

                        if (amountOfSpace % 2 == 0)
                        {
                            text += (tempString.substring(0,1).toUpperCase() +  tempString.substring(1,tempString.length()));
                        }else {
                            text += (tempString.substring(0,tempString.length()-1) +
                                    tempString.substring(tempString.length()-1, tempString.length()).toUpperCase());
                        }

                        text += " ";
                    }

                    text+="\n";
                }

                FileWriter fileWriter = new FileWriter(this.wrapper.getFile());
                fileWriter.write(text);
                fileWriter.flush();
                fileWriter.close();
				System.out.printf("transform %s %s", Thread.currentThread().getName(), this.wrapper.getFile().getName());

            }catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
    }
}
