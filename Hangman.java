class Hangman {
    public static void play(Scanner sc,Random random) {
        String[] words = {"computer","java","hangman","programming","random",
                "scanner","elephant","dog","parrot","cow","snake","crocodile","bench","fan","cupboard","mother",
                "father","children","wolf","kick","mission","impossible","final","reckoning","fallout","ghost",
                "protocol","rogue","nation","avengers","infinity","war","end","game","age","ultron","captain",
                "america","first","soldier","winter","civil","brave","new","world","iron","man","black","widow",
                "hawkeye","thor","ragnarok","dark","love","thunder","doctor","strange","multiverse","madness",
                "wanda","vision","hulk","silver","surfer","shuri","panther","moon","knight","guardians","galaxy",
                "volume","shangchi","rider","venom","wakanda","forever","ant","spider","man","home","coming",
                "amazing","far","super","sheild","steps","wonder","women","marvel","bat","robot","rabbit","ego",
                "lord","gamora","palace","live","neighbours","blue","yellow","green","gray","violet","odin",
                "time","loop","slipping","sun","micro","chips","bots","control","processor","unit","address",
                "bus","statement","inheritance","sorting","quick","insertion","interceptor","force","missile",
                "army","navy","submarine","tank","suitcase"};

        String wordToGuess = words[random.nextInt(words.length)];

        int wordLength = wordToGuess.length();
        int maxAttempts;
        if(wordLength == 3) {
            maxAttempts = 5;
        } else if (wordLength == 4) {
            maxAttempts = 6;
        } else if (wordLength == 5) {
            maxAttempts = 7;
        } else {
            maxAttempts = 7;
        }

        int attempts = 0;
        boolean wordGuessed = false;

        char[] guessedWord = new char[wordLength];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        while (attempts < maxAttempts && !wordGuessed) {
            System.out.print("Guess a letter (press 0 to exit): ");
            char guess = sc.next().toLowerCase().charAt(0);

            
            if (guess == '0') {
                System.out.println("Exiting Hangman...");
                return;
            }

            boolean correctGuess = false;
            for (int i = 0; i < wordLength; i++) {
                if (wordToGuess.charAt(i) == guess && guessedWord[i] == '_') {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attempts++;
                System.out.println("Wrong guess! Attempts left: " + (maxAttempts - attempts));
            }

            System.out.print("Current word: ");
            for (char c : guessedWord) {
                System.out.print(c + " ");
            }
            System.out.println();

            wordGuessed = new String(guessedWord).equals(wordToGuess);
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
            GamingHub.player.score+=10;
        } else {
            System.out.println("Game over! The word was: " + wordToGuess);
        }
    }
}

