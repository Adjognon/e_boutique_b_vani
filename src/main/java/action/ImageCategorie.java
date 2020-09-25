package action;

import javax.servlet.http.HttpServletRequest;
import manager.CategorieManager;
import manager.ImageCategorieManager;

public class ImageCategorie {
    static public void getCategorie(HttpServletRequest request, int categorieId){
        request.setAttribute("categorie", ImageCategorieManager.getImageByCategorieId(categorieId));
    }
}
