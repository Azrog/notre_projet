import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SerialTest implements SerialPortEventListener {

SerialPort serialPort;
/** The port we’re normally going to use. */
private static final String PORT_NAMES[] = {"COM4"};

static Lock cadenas = new ReentrantLock();
private BufferedReader input;
private OutputStream output;
private static final int TIME_OUT = 2000;
private static final int DATA_RATE = 9600;
private static String out = null;

public void initialize() {
    CommPortIdentifier portId = null;
    Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

    //First, Find an instance of serial port as set in PORT_NAMES.
    while (portEnum.hasMoreElements()) {
        CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
        for (String portName : PORT_NAMES) {
            if (currPortId.getName().equals(portName)) {
                portId = currPortId;
                break;
            }
        }
    }
    if (portId == null) {
        System.out.println(" Could not find COM port. ");
        return;
    }

    try {
        serialPort = (SerialPort) portId.open(this.getClass().getName(),
        TIME_OUT);
        serialPort.setSerialPortParams(DATA_RATE,
        SerialPort.DATABITS_8,
        SerialPort.STOPBITS_1,
        SerialPort.PARITY_NONE);

        // open the streams
        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        output = serialPort.getOutputStream();

        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
    } catch (Exception e) {
        System.err.println(e.toString());
    }
}
public synchronized void close() {
    if (serialPort != null) {
    serialPort.removeEventListener();
    serialPort.close();
    }
}

public synchronized void serialEvent(SerialPortEvent oEvent) {
    Lock cadenas = new ReentrantLock();
    cadenas.lock();
    try {
    if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
        try {
            String inputLine="jjj";

            if (input.ready()) {
                inputLine = input.readLine();
                out = input.readLine();
                //String [] chunks = inputLine.split(" , ");
                //System.out.println(out);
                //System.out.println(inputLine);
                //System.out.println(chunks[0] + " \t " + chunks[1] + " \t " + chunks[2] + " \t ");

            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }
    } finally {
        cadenas.unlock();
    }// Ignore all the other eventTypes, but you should consider the other ones.
}
public static String getOut() {
    return out;
}
}