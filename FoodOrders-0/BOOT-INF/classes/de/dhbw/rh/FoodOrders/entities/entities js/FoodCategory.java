package de.dhbw.rh.FoodOrders.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(
   name = "FOODCATEGORY"
)
public class FoodCategory {
   @Id
   @GeneratedValue
   private Long id;
   private String name;
   @ManyToOne
   @JoinColumn(
      name = "menu_id",
      nullable = false
   )
   @JsonBackReference
   private Menu menu;
   @OneToMany(
      mappedBy = "category"
   )
   private List<FoodItem> foodItems;

   public FoodCategory() {
   }

   public FoodCategory(Long id, String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Menu getMenu() {
      return this.menu;
   }

   public void setMenu(Menu menu) {
      this.menu = menu;
   }

   public List<FoodItem> getFoodItems() {
      return this.foodItems;
   }

   public void setFoodItems(List<FoodItem> foodItems) {
      this.foodItems = foodItems;
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         FoodCategory that = (FoodCategory)o;
         return Objects.equals(this.id, that.id) && Objects.equals(this.name, that.name) && Objects.equals(this.menu, that.menu);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.id, this.name, this.menu});
   }

   public String toString() {
      return "FoodCategory{id=" + this.id + ", name='" + this.name + "', menu=" + this.menu + "}";
   }
}
