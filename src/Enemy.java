public class Enemy extends Characters{
        private String name;
        int strengthLevelForEnemy = secureRandom.nextInt(1,5);
        int vitalityLevelForEnemy = secureRandom.nextInt(1,5);
        int intelligenceLevelForEnemy = secureRandom.nextInt(1,5);
        int dexerityForEnemy = secureRandom.nextInt(1,10);
        public Enemy(String name, Weapons weapons){
                setName(name);
                setKind(4);
                setType(type);
                setStrength(strengthLevelForEnemy);
                setVitality(vitalityLevelForEnemy);
                setIntelligence(intelligenceLevelForEnemy);
                setWeaponsRandomly(weapons);
                inventoryFighter.add(weapons);
                setVisible(true);
            }


        @Override
        public void displayInfoForAll(){
                System.out.println("You will fight with the enemy that has the features below: ");
                System.out.println();
                System.out.print("\tStrength of enemy: "+getStrength()+"\n"+
                        " \tVitality of enemy: "+getVitality()+"\n"+
                        " \tIntelligent of enemy: "+getIntelligence()+" \n\tHealth point of enemy: " +
                         calculateHealthPoint(strengthLevelForEnemy,vitalityLevelForEnemy,intelligenceLevelForEnemy));
                         System.out.println();
                      }
        @Override
        public int attack(){
            return (int) ((int)(Math.random()*10)+super.getStrength());
        }

        public int calculateDamageOfEnemy(){
                return 0;
        }
    }

