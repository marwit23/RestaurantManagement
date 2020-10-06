INSERT INTO ingredient (ingredient_category, ingredient_name, shelf_life) VALUES
('GRAINS', 'Flour', '180'),
('GRAINS', 'Bread', '5'),
('GRAINS', 'Pasta', '180'),
('VEGETABLES', 'Onion', '30'),
('VEGETABLES', 'Potato', '10'),
('VEGETABLES', 'Cabbage', '30'),
('DAIRY', 'Milk', '7'),
('DAIRY', 'Cottage Cheese', '7'),
('DAIRY', 'Cheddar', '14'),
('FRUITS', 'Orange', '30'),
('FRUITS', 'Apple', '7'),
('FRUITS', 'Watermelon', '3'),
('MEAT', 'Chicken Breast', '2'),
('MEAT', 'Steak', '5'),
('MEAT', 'Bacon', '10'),
('FATS', 'Butter', '14'),
('FATS', 'Canola Oil', '180'),
('FATS', 'Olive Oil', '180'),
('SPICES', 'Garlic Powder', '180'),
('SPICES', 'Oregano Dried', '180'),
('SPICES', 'Chili Powder', '180');
INSERT INTO delivery (delivered_date, ordered_date) VALUES
('2020-10-04', '2020-10-04'),
('2020-10-05', '2020-10-05'),
('2020-10-06', '2020-10-06');
INSERT INTO delivery_item (price_per_kg, quantity_grams, delivery_id, ingredient_id) VALUES
('1.89', '5000', '1', '1'),
('2.19', '2000', '1', '3'),
('3.25', '2000', '1', '4'),
('2.19', '2000', '1', '7'),
('4.99', '1000', '1', '10'),
('15.89', '2000', '1', '13'),
('35.99', '2000', '1', '14'),
('12.99', '500', '1', '16'),
('4.99', '5000', '1', '17'),
('19.59', '50', '1', '19'),
('19.59', '50', '1', '20'),
('5.20', '500', '2', '2'),
('2.15', '5000', '2', '5'),
('7.29', '500', '2', '8'),
('2.82', '1500', '3', '12'),
('16.99', '500', '3', '15'),
('10.99', '750', '3', '18'),
('21.99', '50', '3', '21');
INSERT INTO dish (dish_name) VALUES
('Bacon Sandwich'),
('French Fries'),
('Pan Seared Steak'),
('Chicken Pasta');
INSERT INTO dish_ingredient (quantity_grams, dish_id, ingredient_id) VALUES
('50', '1', '2'),
('25', '1', '16'),
('50', '1', '15'),
('200', '2', '5'),
('50', '2', '17'),
('300', '3', '14'),
('50', '3', '18'),
('50', '3', '16'),
('3', '3', '19'),
('125', '4', '3'),
('50', '4', '4'),
('150', '4', '13'),
('25', '4', '16'),
('30', '4', '18'),
('3', '4', '19'),
('5', '4', '20');
INSERT INTO to_do_dish (dish_id) VALUES
('1'),
('2'),
('3'),
('4');




