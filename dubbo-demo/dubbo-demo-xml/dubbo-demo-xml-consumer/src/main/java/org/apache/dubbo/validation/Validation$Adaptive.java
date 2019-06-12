package org.apache.dubbo.validation;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class Validation$Adaptive implements Validation {
    public Validator getValidator(org.apache.dubbo.common.URL arg0) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        org.apache.dubbo.common.URL url = arg0;
        String extName = url.getParameter("validation", "jvalidation");
        if (extName == null)
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.validation.Validation) name from url (" + url.toString() + ") use keys([validation])");
        Validation extension = (Validation) ExtensionLoader.getExtensionLoader(Validation.class).getExtension(extName);
        return extension.getValidator(arg0);
    }
}