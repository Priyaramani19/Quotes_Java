package com.example.bestquotes.Screen.HomePage.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bestquotes.R;
import com.example.bestquotes.Screen.HomePage.Controller.Adapter_Quotes;
import com.example.bestquotes.Screen.HomePage.Model.Model_Quotes;
import com.example.bestquotes.Screen.HomePage.Model.Model_category;

import java.util.ArrayList;
import java.util.List;

public class Quotes_Activity extends AppCompatActivity {

    RecyclerView recycler_quotes;
    TextView txt_title;

    String[] images = {"https://soulsofsilver.com/wp-content/uploads/2020/10/iStock-688148142-1.jpg","https://avatars.mds.yandex.net/i?id=c3ee0cf40c9f4a789c753d90e49aa51a-5876743-images-thumbs&n=13","https://avatars.mds.yandex.net/i?id=5b68b7a1a5f3fedf0ab4da5443a52d9e-4697805-images-thumbs&n=13",
            "https://adoptlondon.org.uk/app/uploads/2020/10/SomePeople_Teddy-scaled.jpg","https://avatars.mds.yandex.net/i?id=feb23af0022d282bf89d0c68bfd0ad70-5666076-images-thumbs&n=13", "https://avatars.mds.yandex.net/i?id=5bfb47d694cd058fea9ddb4d1332561e-5452061-images-thumbs&n=13",
            "https://avatars.mds.yandex.net/i?id=8a690bf1d49ac6418e5d0bc0bf83afa6-5877309-images-thumbs&n=13","https://avatars.mds.yandex.net/i?id=dd300eab1cf9c0aecef7043b1a6a26d9-4055786-images-thumbs&n=13", "https://avatars.mds.yandex.net/i?id=529a072dba0bcbf86c18d537890cf577-5474261-images-thumbs&n=13",
            "https://avatars.mds.yandex.net/i?id=29c257ac28965946a5ecf2fad05e2116-5465325-images-thumbs&n=13"};

    String[] temp;

    String[] emotional = {"Some people are more interested in other people's lives than their own.",
                        "Our life are defined by opportunities. Even the ones we miss.",
                        "Sometimes one hello, makes you never want to say goodbye.",
                        "You must be the change you wish to see in the world.",
                        "The best thing about being me, I'm a limited edition, there are no other copies.",
                        "Hardship often prepare ordinary people for an extraordinary destiny.",
                        "It seems impossible to stop thinking about your ex-lover and the memories.",
                        "Why are you trying so hard to fit in when you were born to stand out?",
                        "It doesn't matter what you do. It matter who you do it with.",
                        "Feelings that come back sre feelings that never away."};

    String[] motivational = {"The secret of success is to know something nobody els eknows.",
                            "Life doesn't give you what you want. It gives you what you work for.",
                            "When life locks you in your room, simply go out the window.",
                            "There no mistakes in life, only lessons.",
                            "Once in a while, right in the middle of an ordinary life.",
                            "Do not give up, the beginning is always the hardest.",
                            "Life has no limitations, except the once you make.",
                            "Life is what you make of it. Always has been, always will be.",
                            "Life isn't what yu want it to be, it's what you make it become.",
                            "Life has got to be lives - that's all there is to it."};

    String[] love = {"Thanks for being in my life.",
                    "Everything is fair in love and war.",
                    "My heart is perfect because..you are inside.",
                    "All i need is your love.",
                    "If i could be with you in my drams. I would never wake up.",
                    "Never trust your heart because it's not the right side.",
                    "If love easy,there would be almost no music.",
                    "Fall in love not in line.",
                    "Life is too short to cry on..",
                    "My heart beats only for you."};

    String[] sad = {"A beautiful girl with gorgeous EYES, a hidden world of HURT & LIES.",
                    "Pain is the only thing that's telling me I'm still alive.",
                    "You're the only Exception.",
                    "SLEEP away the sadness of today.",
                    "I hope you'll realize how much you're hurting me somebody.",
                    "Emptiness feels so heavy.",
                    "Sometimes it's better to be alone..",
                    "Never put your happiness in someone else's hands.",
                    "I always found the right one on wrong time.",
                    "My silence is just another word for pain."};

    String[] family = {"Dad a son's first hero, a daughter's first love.",
                        "A family is a little world created by love.",
                        "The love of a family is life's greatest blessing.",
                        "Family where life beings and love never ends...",
                        "The family is a heaven in a heartless world.",
                        "To promote world peace go home and love yur family.",
                        "Family is nt an important thing. It's everything.",
                        "Family is the most important thing in the world.",
                        "Other things may change, but we start and end with family.",
                        "The family is one of the nature's masterpieces."};

    String[] attitude = {"Adopt a right attitude make you the negative thinking to positive thinking.",
                        "If people have a problem with you, always remember, it is THEIR problem.",
                        "I'm cool but summer make me hot!",
                        "Those who know love has also the risk os knowing pain.",
                        "Always remember you are unique, just like everyone else.",
                        "If a plum didn't work, Alphabet has 25 more letters.",
                        "If loving you is wrong, Then i don't want to be right.",
                        "Weakness of attitude becomes weakness of character.",
                        "I am who i am, you approval is not needed.",
                        "Excellence is not a skill, It is an attitude."};

    String[] birthday = {"It's always a treat to wish Happy Birthday to someone so sweet.",
                        "The sun is shining more brightly today as a way to wish you happy birthday.",
                        "I'm so awesome, when i was born, I was given a certificate.",
                        "I'm not good at status stuff ever, just do something cool and fly.",
                        "I'm glad you are part of my life, Happy Birthday.",
                        "A whole day to celebrate.",
                        "Happy Birthday to the most amazing man ever..",
                        "Hope my birthday blossoms into lots of dreams come true!",
                        "Happy Birthday! I hope its filled with love, laughs, and family..",
                        "I hope that today is the beginning of a great year for ME"};

    String[] food = {"Celery is 95% water and 100% not pizza.",
                    "True beauty is within for example opening your fridge.",
                    "I'm not hungry. But, I am bored. Therefore, I shall eat...",
                    "Television + food, it just goes together",
                    "Food is my favorite. If I ever share it with you, then you're pretty damn special.",
                    "My hobbies include eating and complaining that i'm getting fat.",
                    "Is there gonna be food? Yeah Ok then i'm coming.",
                    "LIKE if you can't tell the difference between coke & pepsi.",
                    "I eat so much... I make fat kids look skinny!",
                    "I don't trust people that dislike tacos."};

    String[] marriage = {"Marriage, truth to say is evil, but necessary evil.",
                        "Marriage is a means of survival for two people.",
                        "Love one another and you will be happy. It's as simple and as difficult as that.",
                        "The day we say I DO will be the greatest day of my life.",
                        "Marriage is a short rest between romances.",
                        "Congratulations! God bless you today and for the rest of your married lives",
                        "Marriage is useful for soothing sensuality. It's useless for soothing love.",
                        "Marriage is a short break between novels.",
                        "Marriage is perfect for lovers and suitable for the saints.",
                        "Marriages are made in heaven, but so are thunder and lightning."};

    String[] mother = {"God could not be everywhere, and therefore he made mothers.",
                        "My mother is a walking miracle.",
                        "With what price we pay for the glory of motherhood.",
                        "Life began with waking up and loving my mother's face.",
                        "Mother's love is peace. It need not be acquired, it need not be deserved.",
                        "Children are the anchors that hold a mother to life.",
                        "For when a child is born the mother also is born again.",
                        "Sometimes the strength of motherhood is greater than natural laws.",
                        "All that I am, or hope to be, I owe to my angel mother.",
                        "I got to grow up with a mother who taught me to believe in me."};

    String[] father = {"I wasn't anything special as a father. But I loved them and they knew it.",
                        "To a father growing old nothing is dearer than a daughter.",
                        "My dad's not here, but he's watching in heaven.",
                        "I would want my legacy to be that I was a great son, father and friend.",
                        "One father is more than a hundred schoolmasters.",
                        "My role model is my dad.",
                        "My Dad is my hero.",
                        "We looked up to our father. He still is much greater than us.",
                        "I was raised by my father; I was daddy's girl.",
                        "I'm a father; that's what matters most. Nothing matters more."};

    String[] music = {"I'm listening to music because I don't want to listen to you.",
                    "I'm consuming some loud music.",
                    "Sometimes it feels like music is my only friend.",
                    "Why do they sing? So I don't have to!",
                    "I'm tuning you out and turning up my music.",
                    "Listening to the sweet sound of music.",
                    "When I listen to old songs, the memories hit me.",
                    "Music is the one thing that never betrays me.",
                    "Listening to something more pleasant than you.",
                    "Can't hear you! Listening to music!"};

    String[] shopping = {"Shopping at the dollar store: Making you feel rich and poor all at the same time.",
                        "Shopping is so fun I could do it all year.",
                        "I wanna go shopping.",
                        "I wish I could have unlimited money for shopping.",
                        "My motto in life, Shopping is cheaper than a Psychiatrist!",
                        "If a girl is shopping she's trendy, if boy is shopping he's wasting money.",
                        "I've been shopping for years and I still have nothing to wear.",
                        "I love doing last minute Christmas shopping!",
                        "Money doesn't bring happiness, but shopping does :-)",
                        "Dear fridge, I'll be back in half an hour. Please go shopping. Sincerely, hungry."};

    String[] success = {"You might well remember that nothing can bring you success but yourself.",
                        "The ladder of success is best climbed by stepping on the rungs of opportunity.",
                        "The only place success comes before work is in the dictionary.",
                        "Survival was my only hope, success my only revenge.",
                        "A champion is afraid of losing. Everyone else is afraid of winning.",
                        "They succeed, because they think they can.",
                        "Money won't create success, the freedom to make it will.",
                        "Success is how high you bounce when you hit bottom.",
                        "The starting point of all achievement is desire.",
                        "There is no success without hardship."};

    String[] women = {"Wishing a very happy women's day to the most amazing woman I know...",
                        "Happy Women's Day! Wishing you a day as beautiful as you are!",
                        "This Women's Day just stand tall cos you are the most special woman of my life!!",
                        "Today is yours, and so is ever other day. Happy Women's Day!",
                        "Feel special, unique, on top of the world.. Its your day!! Happy Womens Day.",
                        "Wishing you a day that's just like you.. really special! Happy Women's day!",
                        "Sending you wishes to say you blossom up the world around me! Happy Women's Day!",
                        "This Women's Day just stand tall cos you are the most special woman of my life!",
                        "Whenever group of Women comes with oriented intention, the magic happens.",
                        "Across the miles comes this wish from me to say you are Special! Happy Women's Day."};

    String[] thank_you = {"To my friends thank you for being there for me.",
                            "The sun will not rise or set without my notice, and thanks.",
                            "Dear past, thanks for all the lessons. Dear future, i'm ready.",
                            "Thank you for your lovely wishes it brought smiles to my eyes.",
                            "No duty is more urgent than that of returning thanks.",
                            "Thanks for your support and understanding.",
                            "Just a thank you is a mighty powerful prayer. Says it all.",
                            "For your patience and caring, i just want to say: Thank you.",
                            "Thank you for being my friend.",
                            "Thank you for listening to me."};

    String[] sisters = {"A Loyal Sister IS Worth A Thousand Friends.",
                        "Because angels are sometimes busy elsewhere, God created sisters like you.",
                        "In the cookies of life, sisters are the chocolate chips.",
                        "A sister is for telling secrets and making promises that will never be broken.",
                        "I would like more sisters, that the taking out of one, might not leave such stillness..",
                        "I Love MY Sister because She Cares Meee",
                        "Sister and Friend two words that mean the same.",
                        "Having a sister is like having a best friend for life.",
                        "A sister is a forever friend.",
                        "A true sister is a friend who listens with her heart."};

    String[] rain = {"Lets cuddle on a rainy day Watch Old movies and make out .",
                    "My dream is to hear rocks hitting the window and see you standing in the rain..",
                    "The rain reminds me of you. because it's falling hard and i am too.",
                    "life is a storm either you get a umbrella or learn to dance in the rain.",
                    "I wish I could sit in the rain and let it wash all my worries away.",
                    "It's raining, It's pouring. Facebook is boring.",
                    "Sometimes YOU Win Sometimes You Lose Sometimes It Rains.",
                    "Rain makes a heart GO Romantic.",
                    "I love falling asleep in the sound of rain.",
                    "I find peace inn the rain."};

    String[] party = {"We're all mad here!",
                        "Young n Wild",
                        "Take me drunk I'm home.",
                        "Has often thought that what doesn't kill us makes us drink stronger liquor.",
                        "Thinks that time flies when you're having a drunken blackout.",
                        "Get Set PARTY!",
                        "LET'S HAVE A PARTY.",
                        "We like to party.",
                        "Beer is proof God loves us, and wants us to be happy",
                        "IT'S PARTY TIME."};

    String[] parents = {"Mother love is a fuel that enables the human being to do the impossible.",
                        "Never forgot your parents, they are the reason why you are and who you are.",
                        "My father didn't tell me how to live, he lived and let me watched him do it.",
                        "Parents need to teach their children principles of respect and acceptence.",
                        "No love is greater than mom's love, and no care is greater than dad's care..",
                        "A mother is not a person to lean on but a person to make leaning unnecessary.",
                        "A mother understands what a child does not say.. Happy Mother's Day..",
                        "Home is where your mum is. I love my Mommy.",
                        "Parents are the only God to help and guide you in your life..",
                        "A mother's heart is always with her children."};

    List<Model_Quotes> l1 = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        binding();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));


        String title = getIntent().getStringExtra("n1");
        int position = getIntent().getIntExtra("n2",0);
        txt_title.setText(title);

        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();

        if(position == 0) {
            temp = emotional;
        }else if(position == 1){
            temp = motivational;
        }else if(position == 2){
            temp = love;
        }else if(position == 3){
            temp = sad;
        }else if(position == 4){
            temp = family;
        }else if(position == 5){
            temp = attitude;
        }else if(position == 6){
            temp = birthday;
        }else if(position == 7){
            temp = food;
        }else if(position == 8){
            temp = marriage;
        }else if(position == 9){
            temp = mother;
        }else if(position == 10){
            temp = father;
        }else if(position == 11){
            temp = music;
        }else if(position == 12){
            temp = shopping;
        }else if(position == 13){
            temp = success;
        }else if(position == 14){
            temp = women;
        }else if(position == 15){
            temp = thank_you;
        }else if(position == 16){
            temp = sisters;
        }else if(position == 17){
            temp = rain;
        }else if(position == 18){
            temp = party;
        }else if(position == 19){
            temp = parents;
        }

        for(int i=0;i<images.length;i++){

            Model_Quotes modelQuotes = new Model_Quotes(images[i],temp[i]);
            l1.add(modelQuotes);
        }

        Adapter_Quotes adapterQuotes = new Adapter_Quotes(this,l1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler_quotes.setLayoutManager(layoutManager);
        recycler_quotes.setAdapter(adapterQuotes);
    }

    void binding()
    {
        recycler_quotes = findViewById(R.id.recycler_quotes);
        txt_title = findViewById(R.id.txt_title);
    }
}