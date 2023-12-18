-- Insert into bakery(id, title, price, `limit`, inInterest, category, Information)
-- VALUES
--     (1, 'Fruit Cake', 40, 5, false, 'Fruits', 'Fruit Cake'),
--     (2, 'Classic Cheese Cake', 40, 5, false, 'Cheese', 'Classic Cheese Cake'),
--     (3, 'Chocolate Cocoa Mousse', 30, 5, false, 'Chocolate', 'Chocolate Cocoa Mousse'),
--     (4, 'Green Tea Mousse Cake', 30, 5, false, 'GreenTea', 'Green Tea Mousse Cake'),
--     (5, 'Strawberry Mousse Cake', 30, 5, false, 'Strawberry',  'Strawberry Mousse Cake'),
--     (6, 'Rich Chocolate Cheese Mousse Cake', 30, 5, false, 'Chocolate',  'Rich Chocolate Cheese Mousse Cake'),
--     (7, 'Square Green Tea Cake', 50, 5, false, 'Cheese', 'Square Green Tea Cake'),
--     (8, 'Matcha Cream Cake', 40, 5, false, 'Strawberry', 'Matcha Cream Cake'),
--     (9, 'Chocolate Cake', 20, 5, false, 'Chocolate', 'Chocolate Cake'),
--     (10, 'Strawberry Cheese Cake', 30, 5, false, 'Strawberry',  'Strawberry Cheese Cake');

Insert into cake(id,title, price, inventory, information, imageUrl, category)
VALUES
    (1, 'Dinosaur Cake', 40, 5, 'This cake is a delightful blend of chocolate and caramel, perfect for young adventurers with a sweet tooth.', 'boy_dinosaur.JPG','boys'),
    (2, 'Lego Cake', 40, 5, 'A cake adorned with vibrant colors and fun decorations, guaranteed to make any young boy''s birthday extra special.','boy_Lego.JPG','boys'),
    (3, 'Pikachu Cake', 30, 5,  'Celebrate her grace and sophistication with a cake that exudes beauty and flavor, a true embodiment of femininity.','boy_pikachu.JPG', 'boys'),
    (4, 'Lisa Cake', 30, 5, 'Indulge in the whimsical world of flavors with this enchanting cake, featuring layers of strawberry and vanilla, and adorned with delicate floral designs.','girl_Lisa.JPG', 'girls'),
    (5, 'Moon Cake', 30, 5, 'This cake is a sweet symphony of pink and purple, tailor-made for the princess in your life.','girl_moon.JPG', 'girls'),
    (6, 'Wing Cake', 30, 5, 'Treat the special woman in your life to a cake that''s as elegant as she is – layers of rich red velvet, dressed in a luxurious cream cheese frosting.','her_wing.JPG', 'women'),
    (7, 'Chip Cake', 50, 5, 'This cake is a bold and hearty choice, with layers of espresso-infused chocolate and a whiskey-infused ganache, perfect for the discerning gentleman.','him_chip.JPG', 'men'),
    (8, 'Rolex Cake', 40, 5, 'Indulge in the robust flavors of this cake, designed to satisfy the palate of any man with a taste for the finer things in life.','him_Rolex.JPG', 'men');