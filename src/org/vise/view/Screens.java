package org.vise.view;

/***
 * Enum for the view of the .fxml resources.
 * 
 * @author Mattia Navacchia
 *
 */
public enum Screens {

    /**
     * Player View.
     */
    PLAYER("/org/vise/view/Player.fxml", "/org/vise/view/Player.css"),
    /**
     * RLForm View.
     */
    RLFORM("/org/vise/view/RLForm.fxml", "/org/vise/view/login.css");

    private final String resourcePath;
    private final String cssPath;

    /**
     * 
     * @param resourcePath
     *          path of the source .fxml.
     * @param cssPath
     *          path of the source .css.
     */
    Screens(final String resourcePath, final String cssPath) {
        this.resourcePath = resourcePath;
        this.cssPath = cssPath;
    }

    /**
     * 
     * @return path of the source .fxml
     */
    public String getResourcePath() {
        return resourcePath;
    }

    /**
     * 
     * @return path of the source .css
     */
    public String getCssPath() {
        return cssPath;
    }
}
