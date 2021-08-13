package org.academiadecodigo.shellmurais.files;

import org.academiadecodigo.shellmurais.Messages;

public class NotEnoughSpaceException extends FileException {

    public NotEnoughSpaceException() {
        super(Messages.EXCEPTION_NOT_ENOUGH_SPACE);
    }

}
