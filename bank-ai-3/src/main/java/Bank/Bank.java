package Bank;

import BankingSimulator.Simulator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Bank {
	
	private static final Logger LOG = LogManager.getLogger(Simulator.class);
	
	public static void main(String[] args) {
		
		LOG.trace("Trace message.");
		LOG.debug("Debug message.");
		LOG.info("Info message.");
		LOG.warn("Warn message.");
		LOG.error("Error message.");
		LOG.fatal("Fatal message.");
		
		LOG.trace("Before calling Simulator()");
		Simulator.run();
		LOG.trace("After calling Simulator()");
		
	}
}
