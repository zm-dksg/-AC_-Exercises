package org.academiadecodigo.shellmurais.files;

import org.academiadecodigo.shellmurais.Messages;

public class FileNotFoundException extends FileException {

    public FileNotFoundException() {
        super(Messages.EXCEPTION_FILE_NOT_FOUND);
    }

}
