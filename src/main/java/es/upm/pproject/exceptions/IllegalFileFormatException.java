package es.upm.pproject.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IllegalFileFormatException extends Exception {

	private static final long serialVersionUID = -4676459807571292421L;

	public IllegalFileFormatException(String msg){
        Logger logger = LoggerFactory.getLogger(IllegalFileFormatException.class);
        logger.error(msg);
    }
}
