
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author  Saurabh Jain
 * @version 1.0
 * Practice Example : 8
 *
 * An example which shows a simple Ticker
*/

public class TickerMIDlet extends javax.microedition.midlet.MIDlet 
{
	// The variable for knowing the initialization state
    private boolean init ;

    private Display display ;
    private Form form ;
    private Ticker ticker ;    
    private StringItem sItem ;
    
	public TickerMIDlet()
    {
        // NOTE : Heavy initialisations should be avoided in the constructor of the MIDlet.
		// The MIDlet is in the paused state when the constructor is called.
		// It does not have access to the resources it needs at this stage.
		// Therefore all heavy initialisations should be done in the way shown below in 
		// the startApp method.
    }

    public void startApp() 
    {
		// NOTE : The startApp method is called whenever the Application Management Software(AMS)
		// decides that the MIDlet needs to get activated.
		// During the lifecycle of particular instance of the application this situation may arise
		// many times. Therefore to save un-necessary initialisations every time the startApp method
		// is called by the AMS, we should use a boolean variable to control the number of initialisations to 1.
		if(init == false)
		{
			// This is the first step to using the user interface in MIDP
			// The statement sets the Display object in our display variable
			// This display object is unique to this MIDlet
			this.display = Display.getDisplay(this) ;

			// Initializing form
        	this.form = new Form("Form 1") ;

			// Initializing StringItem
			this.sItem = new StringItem ("Ticker \n","Display's Share Prices.") ;
        	
			// Appending StringItem to the ticker
			this.form.append(this.sItem) ;

        	this.ticker = new Ticker ("ABC 42.45,BBX 32.70.09,CDS 119.3") ;
        
			// Setting ticker on the form
        	this.form.setTicker(ticker) ;

			init = true ;
		}

        this.display.setCurrent(this.form);
    }
    
    public void pauseApp()
	{

    }
    
    /**
     * Destroy must cleanup everything not handled by the garbage collector.
     * In this case there is nothing to cleanup.
     */
    public void destroyApp(boolean unconditional)
	{

    }
}
