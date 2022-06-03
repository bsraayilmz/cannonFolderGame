public class Enemy extends Characters{
        private String name;
        int strengthLevelForEnemy = secureRandom.nextInt(1,5);
        int vitalityLevelForEnemy = secureRandom.nextInt(1,5);
        int intelligenceLevelForEnemy = secureRandom.nextInt(1,5);
        public Enemy(String type, Weapons weapons){
                setType(type);
                setStrength(strengthLevelForEnemy);
                setVitality(vitalityLevelForEnemy);
                setIntelligence(intelligenceLevelForEnemy);
                setWeaponsRandomly(weapons);
                inventoryFighter.add(weapons);
            }



        @Override
        public void displayInfoForAll(){
            System.out.println("Strengt of enemy: "+getStrength()+"\n"+
                    "Vitality of enemy: "+getVitality()+"\n"+
                    "Intelligent of enemy: "+getIntelligence()+
                    "\nHit point of Enemy:"+super.getHealthPoint());
        }
        @Override
        public int attack(){
            return (int) ((int)(Math.random()*10)+super.getStrength());
        }


    }

