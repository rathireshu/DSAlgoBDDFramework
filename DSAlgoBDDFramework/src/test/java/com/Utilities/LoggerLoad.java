package com.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*Primarily there are five kinds of log levels and below all are supported in Log4j2.
 * 
All — This level of logging will log everything ( it turns all the logs on )
DEBUG — print the debugging information and is helpful in development stage
INFO — print informational message that highlights the progress of the application
WARN — print information regarding faulty and unexpected system behavior.
ERROR — print error message that might allow system to continue
FATAL — print system critical information which are causing the application to crash
OFF — No logging
*/

public class LoggerLoad {

	private static Logger log = LogManager.getLogger();

	public static void debug(String message) {
		log.debug(message);
	}

	public static void info(String message) {
		log.info(message);
	}

	public static void warn(String message) {
		log.warn(message);
	}

	public static void error(String message) {
		log.error(message);
	}

	public static void fatal(String message) {
		log.fatal(message);
	}

}
