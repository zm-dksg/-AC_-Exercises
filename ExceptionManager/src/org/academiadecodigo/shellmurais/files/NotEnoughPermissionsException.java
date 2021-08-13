package org.academiadecodigo.shellmurais.files;

import org.academiadecodigo.shellmurais.Messages;

public class NotEnoughPermissionsException extends FileException {

    public NotEnoughPermissionsException() {
        super(Messages.EXCEPTION_NOT_ENOUGH_PERMISSIONS);
    }

}
