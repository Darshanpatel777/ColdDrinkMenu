package com.example.colddrinkmenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

public class RecipePagerAdapter extends PagerAdapter {

    private final Context context;
    private final int cuisineIndex;



    private final String[][] colddrinkNames = {
            {"Kiwi Zing", "Exotic Punch", "Mango Tango", "Strawberry Sunrise", "Cranberry Zest", "Watermelon Wonder", "Lychee Lemon Splash", "Dragon-fruit Delight"},
            {"Berry Blast", "Avocado Dream", "Choco Banana Delight", "Mango Magic", "Super Green Detox", "Raspberry Yogurt Swirl", "Strawberry Banana Rush", "Pineapple Coconut Bliss"},
            {"Blue Lagoon", "Virgin Mojito", "Cherry Bliss", "Cucumber Breeze", "Cranberry Fizz", "Mango Mint Cooler", "Lemon Basil Cooler", "Orange Blossom Fizz"},
            {"Midnight Mocha", "Oreo Crumble Shake", "Cookie Dough Shake", "Brownie Fudge Shake", "White Chocolate Raspberry", "Coconut Almond Shake", "Red Velvet Shake", "Maple Pecan Shake"},
            {"Iced Caramel Coffee", "Chilled Rose Latte", "Lemon Iced Tea", "Iced Mocha Bliss", "Coconut Iced Latte", "Honey Lemon Iced Green Tea", "Thai Iced Tea", "Watermelon Cooler"},
            {"Aloe Vera Cooler", "Green Detox Splash", "Minty Honey Lemon", "Ginger Zest Detox", "Cucumber Aloe Refresher", "Basil Lime Detox", "Turmeric Glow Drink", "Herbal Mint Refresher"},
            {"Banana Peanut Protein Shake", "Chocolate Protein Power", "Berry Oat Smoothie", "Green Power Smoothie", "Strawberry Protein Punch", "Spinach Apple Protein Shake", "Walnut Date Energy Shake", "Hazelnut Cocoa Protein Smoothie"},
            {"Japanese Yuzu Cooler", "Tamarind Spice Cooler", "Lychee Rose Infusion", "Guava Lime Refresher", "Pineapple Basil Cooler", "Fig Honey Cooler", "Basil Coconut Crush", "Passion-fruit Mint Fizz"}
    };


    private final String[][] coldDrinkIngredients = {
            {"Orange Juice, Pineapple Juice, Mango Puree, Lime Juice", "Grapefruit Juice, Pomegranate Juice, Lemon Juice",
                    "Orange Juice, Lemon Juice, Lime Juice, Mint", "Pineapple Juice, Coconut Milk, Mango Puree, Ice",
                    "Strawberry Puree, Orange Juice, Lemon Juice", "Carrot Juice, Orange Juice, Pineapple Juice, Ginger",
                    "Kiwi Puree, Pineapple Juice, Lime Juice, Mint", "Mango Juice, Strawberry Puree, Lemon Juice",
                    "Passion Fruit Juice, Mango Juice, Pineapple Juice, Orange Juice", "Pineapple Juice, Coconut Milk, Mint, Lime",
                    "Mango Juice, Pineapple Juice, Lime Juice, Ice", "Strawberry Puree, Orange Juice, Pineapple Juice",
                    "Cranberry Juice, Orange Juice, Lime Juice, Mint", "Green Apple Juice, Lemon Juice, Mint, Ginger",
                    "Passion Fruit Juice, Orange Juice, Lemon Juice", "Watermelon Puree, Lemon Juice, Mint",
                    "Peach Puree, Mango Juice, Pineapple Juice", "Lychee Juice, Lemon Juice, Lime Juice",
                    "Dragonfruit Puree, Pineapple Juice, Coconut Milk", "Raspberry Puree, Lemon Juice, Lime Juice"},
            {"Mixed Berries, Banana, Yogurt, Almond Milk", "Avocado, Banana, Spinach, Almond Milk", "Banana, Cocoa Powder, Yogurt, Almond Milk",
                    "Mango Puree, Pineapple Juice, Coconut Milk", "Kale, Spinach, Green Apple, Cucumber, Lemon Juice",
                    "Raspberries, Yogurt, Honey, Almond Milk", "Coconut Milk, Pineapple, Mango, Yogurt", "Dragonfruit, Mango, Coconut Milk, Lime Juice",
                    "Coconut Milk, Banana, Pineapple, Honey", "Blueberries, Banana, Greek Yogurt, Almond Milk", "Kiwi, Kale, Green Apple, Lemon Juice",
                    "Strawberry, Banana, Yogurt, Almond Milk", "Pineapple, Coconut Milk, Mango", "Cherries, Vanilla Extract, Greek Yogurt",
                    "Chia Seeds, Mixed Berries, Almond Milk", "Apple, Cinnamon, Yogurt, Almond Milk", "Peanut Butter, Banana, Oats, Almond Milk",
                    "Papaya, Mango, Coconut Milk", "Almond Butter, Cocoa, Banana, Almond Milk", "Vanilla Extract, Almond Milk, Banana, Yogurt"},
            {"Blue Curacao Syrup, Lemon Juice, Soda Water", "Lime, Mint, Soda Water, Sugar", "Cherry Juice, Lemon Juice, Club Soda",
                    "Rose Syrup, Lemon Juice, Sparkling Water", "Cucumber, Mint, Lime Juice, Soda Water", "Orange Juice, Cranberry Juice, Sparkling Water",
                    "Pineapple Juice, Lime Juice, Soda Water", "Cranberry Juice, Lemon Juice, Sparkling Water",
                    "Passionfruit Juice, Lime Juice, Soda Water", "Mango Juice, Mint, Lime Juice, Soda Water", "Lemon Juice, Basil, Soda Water, Sugar",
                    "Orange Blossom Water, Orange Juice, Soda Water", "Strawberry Puree, Lime Juice, Soda Water", "Mixed Berries, Mint, Lime, Soda Water",
                    "Watermelon, Lemon Juice, Mint, Sugar", "Apple Cider Vinegar, Lemon Juice, Sparkling Water",
                    "Honeydew, Mint, Lime Juice, Soda Water", "Pomegranate Juice, Lemon Juice, Soda Water",
                    "Peach Juice, Raspberry, Lime Juice, Sparkling Water", "Elderflower Syrup, Lemon Juice, Sparkling Water"},
            {"Coffee, Caramel Syrup, Ice Cream, Milk", "Oreo Cookies, Ice Cream, Milk", "Pistachios, Ice Cream, Milk, Honey",
                    "Caramel Syrup, Pecans, Ice Cream, Milk", "Cookie Dough, Ice Cream, Milk", "Nutella, Banana, Ice Cream, Milk",
                    "Honey, Almond Butter, Ice Cream, Milk", "Chocolate Syrup, Strawberry, Ice Cream", "Peanut Butter, Chocolate, Ice Cream, Milk",
                    "Vanilla Ice Cream, Milk, Sugar", "Brownie Pieces, Chocolate Syrup, Ice Cream", "Butterscotch Syrup, Ice Cream, Milk",
                    "White Chocolate, Raspberries, Ice Cream", "Coconut Milk, Almond Butter, Ice Cream", "Red Velvet Cake, Ice Cream, Milk",
                    "Coffee, Mascarpone, Ice Cream", "Graham Cracker, Chocolate, Marshmallows, Ice Cream", "Coffee, Caramel Syrup, Milk",
                    "Maple Syrup, Pecans, Ice Cream", "Marshmallows, Chocolate Syrup, Ice Cream"},
            { "Iced Coffee, Caramel Syrup, Ice Cream", "Rose Syrup, Milk, Ice", "Lemon, Ice Tea Bags, Sugar", "Hibiscus Flowers, Water, Sugar",
                    "Ginger, Honey, Lime, Sparkling Water", "Thai Tea, Condensed Milk, Ice", "Lavender, Lemon Juice, Sparkling Water",
                    "Apple Cider, Cinnamon, Honey", "Watermelon Juice, Lime", "Cucumber, Lime, Mint, Soda Water", "Iced Mocha, Chocolate Syrup, Milk",
                    "Cold Brew Coffee, Ice, Milk", "Matcha Powder, Mint, Milk", "Vanilla Syrup, Cold Brew Coffee, Milk",
                    "Coconut Milk, Iced Coffee, Vanilla Syrup", "Green Tea, Lemon, Honey", "Earl Grey Tea, Lemon Juice, Soda Water",
                    "Chai Tea, Cinnamon, Milk", "Almond Milk, Mocha Syrup, Coffee", "Rose Syrup, Milk, Ice"},
            { "Aloe Vera Juice, Lemon Juice, Water", "Cucumber, Lemon Juice, Mint", "Ginger, Lemon, Honey, Water", "Cucumber, Lemon, Turmeric",
                    "Basil Leaves, Lime Juice, Water", "Turmeric, Lemon Juice, Ginger, Water", "Charcoal Powder, Lemon Juice, Water",
                    "Mint Leaves, Lemon Juice, Water", "Berry Mix, Chia Seeds, Water", "Lemongrass, Water, Lime Juice",
                    "Chia Seeds, Coconut Water, Lime Juice", "Moringa Powder, Coconut Water", "Beetroot, Berries, Water, Lime",
                    "Spirulina Powder, Coconut Water, Lemon Juice"},
            { "Bananas, Peanut Butter, Protein Powder, Milk", "Almond Butter, Coffee, Protein Powder, Milk", "Chocolate, Protein Powder, Milk",
                    "Berries, Oats, Protein Powder", "Mocha, Coffee, Protein Powder, Ice", "Mango, Chia Seeds, Protein Powder, Milk",
                    "Green Vegetables, Protein Powder, Almond Milk", "Whey Protein, Pineapple, Milk", "Strawberries, Protein Powder, Almond Milk",
                    "Espresso, Caramel, Protein Powder, Milk", "Matcha Powder, Protein Powder, Milk", "Bananas, Coconut, Protein Powder, Milk",
                    "Spinach, Apple, Protein Powder, Milk", "Walnuts, Dates, Protein Powder, Almond Milk", "Hazelnuts, Cocoa, Protein Powder"},
            { "Saffron, Rose Water, Milk", "Yuzu Fruit, Lemon Juice, Soda Water", "Dragonfruit, Lemon Juice, Water",
                    "Coconut, Lime Juice, Water", "Tamarind, Spices, Sugar, Water", "Kiwi, Cucumber, Lime Juice",
                    "Cardamom, Milk, Ice", "Pomegranate, Mint, Water"},
    };


    private final String[][] colddrinkinstruction = {
            {
                    "1. Mix fresh orange juice with a hint of lime." + "\n"+
                    "2. Blend fresh berries with a splash of sparkling water."+ "\n"+
                    "3. Combine citrus fruits and pineapple juice for a tangy base."
                    // Add more instructions for each drink in this category
            },
            {
                    "1. Blend frozen raspberries with yogurt and honey."+ "\n"+
                    "2. Add spinach and kale to a smoothie base with almond milk."+ "\n"+
                    "3. Mix coconut milk with tropical fruits for a creamy texture."
                    // Add more instructions for each drink in this category
            },
            {
                    "1. Shake lime juice and mint leaves for a fresh mojito."+ "\n"+
                    "2. Combine pomegranate juice with sparkling water for a fizzy treat."+ "\n"+
                    "3. Add fresh cucumber juice with a touch of basil."
                    // Add more instructions for each drink in this category
            },
            {
                    "1. Blend coffee with chocolate syrup and milk."+ "\n"+
                    "2. Add crushed ice, Nutella, and vanilla ice cream for a creamy shake."+ "\n"+
                    "3. Mix caramel with crushed nuts for a nutty drink."
                    // Add more instructions for each drink in this category
            },
            {
                    "1. Brew strong coffee and add chilled milk for an iced coffee."+ "\n"+
                    "2. Combine citrus flavors with cold brew for a refreshing drink."+ "\n"+
                    "3. Add rose petals to tea for a floral iced beverage."
                    // Add more instructions for each drink in this category
            },
            {
                    "1. Mix cucumber, mint, and lemon for a refreshing detox drink."+ "\n"+
                    "2. Blend aloe vera with lime juice and mint for a hydrating refresher."+ "\n"+
                    "3. Combine chia seeds with green tea for a healthy drink."
                    // Add more instructions for each drink in this category
            },
            {
                    "1. Blend banana with peanut butter and protein powder for an energy boost."+ "\n"+
                    "2. Add cocoa and almond butter to create a chocolate protein shake."+ "\n"+
                    "3. Mix spinach with almond milk for a green power smoothie."
                    // Add more instructions for each drink in this category
            },
            {
                    "1. Brew saffron with rose milk for a fragrant drink."+ "\n"+
                    "2. Mix tamarind with spices for a tangy punch."+ "\n"+
                    "3. Blend fig with honey for a sweet, refreshing drink."
                    // Add more instructions for each drink in this category
            }
    };

    private final int[][] colddrinkImages = {
            {R.drawable.kiwizing, R.drawable.exoticpunch, R.drawable.mangotango, R.drawable.strawberrysunrise,
                    R.drawable.cranberryzest, R.drawable.watermelonwonder, R.drawable.lycheelemonsplash, R.drawable.dragonfruitdelight},
            {R.drawable.berryblast, R.drawable.avocadodream, R.drawable.chocobananadelight, R.drawable.mangomagic,
                    R.drawable.supergreendetox, R.drawable.raspberryyogurtswirl, R.drawable.strawberrybananarush, R.drawable.pineapplecoconutbliss},
            {R.drawable.bluelagoon, R.drawable.virginmojito, R.drawable.cherrybliss, R.drawable.cucumberbreeze,
                    R.drawable.cranberryfizz, R.drawable.mangomintcooler, R.drawable.lemonbasilcooler, R.drawable.orangeblossomfizz},
            {R.drawable.midnightmocha, R.drawable.oreocrumbleshake, R.drawable.cookiedoughshake, R.drawable.browniefudgeshake,
                    R.drawable.whitechocolateraspberry, R.drawable.coconutalmondshake, R.drawable.redvelvetshake, R.drawable.maplepecanshake},
            {R.drawable.icedcaramelcoffee, R.drawable.chilledroselatte, R.drawable.lemonicedtea, R.drawable.icedmochabliss,
                    R.drawable.coconuticedlatte, R.drawable.honeylemonicedgreentea, R.drawable.thaiicedtea, R.drawable.watermeloncooler},
            {R.drawable.aloeveracooler, R.drawable.greendetoxsplash, R.drawable.mintyhoneylemon, R.drawable.gingerzestdetox,
                    R.drawable.cucumberaloerefresher, R.drawable.basillimedetox, R.drawable.turmericglowdrink, R.drawable.herbalmintrefresher},
            {R.drawable.bananapeanutproteinshake, R.drawable.chocolateproteinpower, R.drawable.berryoatsmoothie, R.drawable.greenpowersmoothie,
                    R.drawable.strawberryproteinpunch, R.drawable.spinachappleproteinshake, R.drawable.walnutdateenergyshake, R.drawable.hazelnutcocoaproteinsmoothie},
            {R.drawable.japaneseyuzucooler, R.drawable.tamarindspicecooler, R.drawable.lycheeroseinfusion, R.drawable.guavalimerefresher,
                    R.drawable.pineapplebasilcooler, R.drawable.fighoneycooler, R.drawable.basilcoconutcrush, R.drawable.passionfruitmmintfizz},
    };

    public RecipePagerAdapter(Context context, int cuisineIndex) {

        this.context = context;
        this.cuisineIndex = cuisineIndex;
    }
    @Override
    public int getCount() {
        return colddrinkImages[cuisineIndex].length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @SuppressLint("MissingInflatedId")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_colddrink_slider, container, false);

        ImageView imageView = view.findViewById(R.id.colddrinkimage1);
        TextView textView = view.findViewById(R.id.colddrinkname1);
        TextView dtl1 = view.findViewById(R.id.detail1);
        TextView dtl2 = view.findViewById(R.id.detail2);

//        animation add karava
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.zoom);
        Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.zoom);
        imageView.setImageResource(colddrinkImages[cuisineIndex][position]);
        textView.setText(colddrinkNames[cuisineIndex][position]);


        //        animation set karava
        imageView.startAnimation(animation);
        textView.startAnimation(animation2);

        // Check if the position is within bounds before accessing the array
        if (position < coldDrinkIngredients[cuisineIndex].length) {
            dtl1.setText(coldDrinkIngredients[cuisineIndex][position]);
        } else {
            dtl1.setText("Ingredients not available");
        }

        if (position < colddrinkinstruction[cuisineIndex].length) {
            dtl2.setText(colddrinkinstruction[cuisineIndex][position]);
        } else {
            dtl2.setText("Instructions not available");
        }

        container.addView(view);

        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
    public String[] getColdDrinkNames(int cuisineIndex) {
        return colddrinkNames[cuisineIndex]; // Return recipe names for the current cuisine
    }
}

