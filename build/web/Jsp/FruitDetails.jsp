<%-- 
    Document   : FruitDetails
    Created on : Dec 19, 2022, 6:56:04 PM
    Author     : Naser
--%>

<%@page import="model.Fruit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fruit Details</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="Css/css.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            Fruit fruit = (Fruit) request.getAttribute("fruit");
            if (fruit != null) {
        %>

        <div class="fdetail">

            <table>
                <thead>
                    <tr>
                        <td colspan="2">
                            <img src="images\<%=fruit.image%>" width="100%" height="150px"/>
                        </td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Id</td>
                        <td><%= fruit.id%></td>
                    </tr>
                    <tr>
                        <td>Fruit Name</td>
                        <td><%= fruit.fruitName%></td>
                    </tr>
                    <tr>
                        <td>Gram</td>
                        <td><%= fruit.gram%></td>
                    </tr>
                    <tr>
                        <td>Calories</td>
                        <td><%= fruit.Calories%></td>
                    </tr>
                    <tr>
                        <td>Calories From Fat</td>
                        <td><%= fruit.CaloriesfromFat%></td>
                    </tr>
                    <tr>
                        <td>Total Fat_g</td>
                        <td><%= fruit.TotalFat_g%></td>
                    </tr>
                    <tr>
                        <td>Sodium_mg</td>
                        <td><%= fruit.Sodium_mg%></td>
                    </tr>
                    <tr>
                        <td>Potassium_mg</td>
                        <td><%= fruit.Potassium_mg%></td>
                    </tr>
                    <tr>
                        <td>Total Carb_g</td>
                        <td><%= fruit.TotalCarb_g%></td>
                    </tr>
                    <tr>
                        <td>Dietary Fiber_g</td>
                        <td><%= fruit.DietaryFiber_g%></td>
                    </tr>
                    <tr>
                        <td>Sugars_g</td>
                        <td><%= fruit.Sugars_g%></td>
                    </tr>
                    <tr>
                        <td>Protein_g</td>
                        <td><%= fruit.Protein_g%></td>
                    </tr>
                    <tr>
                        <td>Vitamin A_DV</td>
                        <td><%= fruit.VitaminA_DV%></td>
                    </tr>
                    <tr>
                        <td>Vitamin C_DV</td>
                        <td><%= fruit.VitaminC_DV%></td>
                    </tr>
                    <tr>
                        <td>Calcum DV</td>
                        <td><%= fruit.Calcum_DV%></td>
                    </tr>
                    <tr>
                        <td>Iron DV</td>
                        <td><%= fruit.Iron_DV%></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td><a href ='Control?cmd=Fruits'>Back</a></td> 
                        <td><a href ='Control?cmd=FruitAS&id=<%=fruit.id%>'> Add To List</a></td>
                    </tr>
                </tfoot>
            </table>

        </div>
        <%} else {%>
        <h1>there are no Fruit</h1>
        <%}%>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
