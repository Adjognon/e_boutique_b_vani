<%-- 
    Document   : index
    Created on : Jan 18, 2020, 5:19:53 PM
    Author     : kadjogno
--%>

<%@page import="manager.PanierManager"%>
<%@page import="manager.SessionManager"%>
<%@page import="entite.User"%>
<%@page import="entite.Categorie"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Aguafina+Script&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="icon" href="sources/reebonz-max-mara-weekend-necklace-bijou-beige-yellow-khaki-max-mara-1-119f1bbc-e3df-4fd0-a1b5-7d514443fc9f.jpg">
        <link href="css/style.css" rel="stylesheet">
        <title>B-Vanani Acceuil</title>
    </head>
    <body>
        
        <%   User utilisateur = (User) SessionManager.getSession(request, "utilisateur");  %>
       
        <ul>
            <a href="categorieControleur" style="text-decoration: none; cursor:pointer;"><label>b-vani</label></a>
            <div style="float:right;">
            <li><a class="active" href="">Acceuil</a></li>
            <li style="position:relative;"><a href="panierControleur"><i style="font-size:24px" class="fa">&#xf07a;<span class="nbPanier"><%= PanierManager.getNbProduitDsPanier(SessionManager.getSession(request, "panier")) %></span></i></a></li>
            <%if(utilisateur != null){
                %>
                <li><a href=""><%= utilisateur.getEmail() %></a></li>
                <li><a href="logControleur?rdr=3">Deconnexion</a></li>
               <%
            }else{
                %>
                <li><a href="logControleur?rdr=0">Connexion</a></li>
                <li><a href="logControleur?rdr=1">Inscription</a></li>
                <%
                 }
                 %>
            </div>
        </ul>
        
        
        <header id="header"> 
            <div id="sub_header">
            <div><img src="sources/reebonz-max-mara-weekend-necklace-bijou-beige-yellow-khaki-max-mara-1-119f1bbc-e3df-4fd0-a1b5-7d514443fc9f.jpg" /></div>
            <div><img src="sources/9611770_fpx.jfif" /></div>
            <div><img src="sources/images-pied_.jfif" /></div> 
            <div><img src="sources/50220083td_12_f.jpg" /></div> 
            <div><img src="sources/download.jfif" /></div>
            </div>
        <header/>
       
        <main>
         <div class="f_section" style="background-image: url(sources/c8c88dff059abc16ba224da45162d992.jpg);">
                <h1>B-Vani</h1>
                <h2>E-Boutique pour du blings</h2>
            </div>
            
            <secion id="s_section">
                
                <%
                    ArrayList<Categorie> categorieList = (ArrayList<Categorie>) request.getAttribute("categorie");
                    for (Categorie categorie : categorieList) {
                           %>
                           <article>
                               <a href="produitsControleur?id_ctg=<%= categorie.getId() %>"><img src="<%= categorie.getUrlImage() %>"/></a>
                            <label><%= categorie.getNom() %></label>
                           </article>
                           <%
                           
                        
                        }
                    
                    
                 %>
                
                
                
                <video src="sources/PE2019_acc_video_collection.mp4" autoplay loop controls> </video>
                
            </secion>
            
            <footer>
                
             <section class='last_products_visited'>
                <div id="sub_header">
            <div><img src="sources/reebonz-max-mara-weekend-necklace-bijou-beige-yellow-khaki-max-mara-1-119f1bbc-e3df-4fd0-a1b5-7d514443fc9f.jpg" /></div>
            <div><img src="sources/9611770_fpx.jfif" /></div>
            <div><img src="sources/images-pied_.jfif" /></div> 
            <div><img src="sources/50220083td_12_f.jpg" /></div> 
            <div><img src="sources/download.jfif" /></div>
            </div>
            </section>
                
                
              <div class="footer_background_image" style='background-image: url(sources/girl-trying-to-break-necklace-jewelry-wide-hd-wallpaper1.jpg);  background-repeat: no-repeat;
                   background-size: 100% 100%; height:700px; position:absolute; top:0px;'>
              </div>
                <div class="footer_contains">
                <hr class="hr"/>
                
                <aside class="l_aside">
                    
                    <div id="myMap">
                        
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d357414.1819438208!2d-73.45569980029913!3d45.584547876472406!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4cc918e0c061b07f%3A0x647a6b6d7cb681a7!2sISI%2C%20L&#39;institut%20Sup%C3%A9rieur%20d&#39;Informatique!5e0!3m2!1sen!2sca!4v1579404570488!5m2!1sen!2sca" width="650" height="300" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
                        
                    </div>
                    
                    
                    <div id="social_networks">

                        <a href="#" class="fa fa-facebook"></a>
<a href="#" class="fa fa-twitter"></a>
<a href="#" class="fa fa-youtube"></a>
<a href="#" class="fa fa-instagram"></a>
                        
                    </div>
                   
                    <div id="payement_accepte">   
                <h4>Payement accepté</h4>
                    <i class="fa fa-cc-visa" style="color:navy;"></i>
                    <i class="fa fa-cc-amex" style="color:blue;"></i>
                    <i class="fa fa-cc-mastercard" style="color:red;"></i>
                    <i class="fa fa-cc-discover" style="color:orange;"></i>
                    </div>
                </aside>
                
                
                
                
                <aside class="r_aside">
                    
                    <h1>Contactez nous</h1>
                    <input type="text" placeholder="Nom"/><br />
                    <input type="email" placeholder="Email"/><br />
                    <textarea></textarea><br />
                    <input class="message_submit" type="submit" value="Envoyer" />
                    
                </aside>
                
                
                </div>
                
                <div id="all_right_reserved">
                
                B - Vani © Tous droits reservés 2020 - 2021
                
            </div>
            </footer>
       
            
        </main>
      
         
       
    </body>
    
</html>
