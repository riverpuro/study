package proxy;

public class PrinterProxy implements Printable {
    private String name;
    private final String subjectClassName;
    private Printable real;

    public PrinterProxy(String subjectClassName) {
        this.subjectClassName = subjectClassName;
    }

    public PrinterProxy(String subjectClassName, String name) {
        this(subjectClassName);
        this.name = name;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {
        if (real == null) {
            real = getReal(subjectClassName);
            real.setPrinterName(name);
        }
    }

    private Printable getReal(String className) {
        try {
            return (Printable) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}