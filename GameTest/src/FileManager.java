import java.util.ArrayList;
import java.util.List;

/**
 * FileManager class is the class that creates level details and items 
 * by reading them from corresponding files
 */
public class FileManager {

	private LevelManager levelManager; //reference to level manager which creates FileManager
	
	//Constructor of FileManager - it takes reference to LevelManager
	public FileManager(LevelManager levelManager) {
		this.levelManager = levelManager;
	}

	//Instantiates level objects and details given the frameWidth and level number
	public void createLevelFromFile( int frameWidth, int levelId ){
			if( levelId == 1){
				levelManager.setLevelTimePeriod(30);
				levelManager.setLevelPointThreshold(50);
				levelManager.setCoinCoefficient(1);
				
				//Target Planes
				TargetPlane tp = new TargetPlane(TargetPlaneEnum.REPUBLIC_ATTACK.image(), TargetPlaneEnum.REPUBLIC_ATTACK.health(),frameWidth, 1400, 1,  TargetPlaneEnum.REPUBLIC_ATTACK.shoot());
				TargetPlane tp2 = new TargetPlane(TargetPlaneEnum.IMPERIAL_SHUTTLE.image(), TargetPlaneEnum.IMPERIAL_SHUTTLE.health(),frameWidth, 900, 8,  TargetPlaneEnum.IMPERIAL_SHUTTLE.shoot());
				TargetPlane tp3 = new TargetPlane(TargetPlaneEnum.F16.image(), TargetPlaneEnum.F16.health(), frameWidth, 780, 12, TargetPlaneEnum.F16.shoot());
				TargetPlane tp4 = new TargetPlane(TargetPlaneEnum.REPUBLIC_ATTACK.image(), TargetPlaneEnum.REPUBLIC_ATTACK.health(),frameWidth, 1000, 21,  TargetPlaneEnum.REPUBLIC_ATTACK.shoot());
				
				List<TargetPlane> targetPlanes = new ArrayList<TargetPlane>();
				
				targetPlanes.add(tp);
				targetPlanes.add(tp2);
				targetPlanes.add(tp3);
				targetPlanes.add(tp4);
				levelManager.setCreatedTargetPlanes(targetPlanes);
				//Targets
				
				Rocket rocket1 = new Rocket(RocketEnum.SMALL.damage(), RocketEnum.SMALL.damageArea(), 
				50, frameWidth, 200, 4);
				Rocket rocket2 = new Rocket(RocketEnum.LARGE.damage(), RocketEnum.LARGE.damageArea(), 
						RocketEnum.LARGE.health(), frameWidth, 300, 20);

				List<Target> targets = new ArrayList<Target>();
				targets.add(rocket1);
				targets.add(rocket2);

				Ally ally1 = new Ally(AllyEnum.ALDERAAN_CRUISER.image(), 
						AllyEnum.ALDERAAN_CRUISER.health(), frameWidth, 230, 10);
				Ally ally2 = new Ally(AllyEnum.SAAB_GRIPEN.image(), 
						AllyEnum.SAAB_GRIPEN.health(), frameWidth, 700, 21);
				
				targets.add(ally1);
				targets.add(ally2);
				
				Carriage carriage1 = new Carriage(CarriageEnum.SMALL.health(), frameWidth, 450, 5);
				Carriage carriage3 = new Carriage(CarriageEnum.LARGE.health(), frameWidth, 680, 18);
				Carriage carriage4 = new Carriage(CarriageEnum.LARGE.health(), frameWidth, 1300, 20);
				targets.add(carriage1);
				targets.add(carriage3);
				targets.add(carriage4);
				
				levelManager.setCreatedTargets(targets);
			
				
				HealthBonusPackage bp1 = new HealthBonusPackage(50, frameWidth, 1250, 10);
				
				List<BonusPackage> bonusPackages = new ArrayList<BonusPackage>();
				bonusPackages.add(bp1);
				levelManager.setCreatedBonusPackages(bonusPackages); 
				
			}
			else if( levelId == 2 ){
				levelManager.setLevelTimePeriod(60);
				levelManager.setLevelPointThreshold(1000);
				levelManager.setCoinCoefficient(2);
				//Target Planes
				TargetPlane tp = new TargetPlane(TargetPlaneEnum.F16.image(), TargetPlaneEnum.F16.health(),frameWidth, 800, 0,  TargetPlaneEnum.F16.shoot());
				TargetPlane tp2 = new TargetPlane(TargetPlaneEnum.IMPERIAL_SHUTTLE.image(), TargetPlaneEnum.IMPERIAL_SHUTTLE.health(),frameWidth,500, 2,  TargetPlaneEnum.IMPERIAL_SHUTTLE.shoot());
				TargetPlane tp3 = new TargetPlane(TargetPlaneEnum.F16.image(), TargetPlaneEnum.F16.health(), frameWidth,1500,5, TargetPlaneEnum.F16.shoot());
				TargetPlane tp4 = new TargetPlane(TargetPlaneEnum.REPUBLIC_ATTACK.image(), TargetPlaneEnum.REPUBLIC_ATTACK.health(),frameWidth,1000,15,  TargetPlaneEnum.REPUBLIC_ATTACK.shoot());
				TargetPlane tp5 = new TargetPlane(TargetPlaneEnum.HAVOC_MARAUDER.image(), TargetPlaneEnum.HAVOC_MARAUDER.health(),frameWidth,800,26,  TargetPlaneEnum.HAVOC_MARAUDER.shoot());
				TargetPlane tp6 = new TargetPlane(TargetPlaneEnum.F16.image(), TargetPlaneEnum.F16.health(), frameWidth, 1320, 37,  TargetPlaneEnum.F16.shoot());
				TargetPlane tp7 = new TargetPlane(TargetPlaneEnum.HAVOC_MARAUDER.image(), TargetPlaneEnum.HAVOC_MARAUDER.health(),frameWidth, 1270, 39,  TargetPlaneEnum.HAVOC_MARAUDER.shoot());
				TargetPlane tp8 = new TargetPlane(TargetPlaneEnum.BOSS.image(), TargetPlaneEnum.BOSS.health(),frameWidth, 520, 48,  TargetPlaneEnum.BOSS.shoot());
				List<TargetPlane> targetPlanes = new ArrayList<TargetPlane>();
				
				targetPlanes.add(tp);
				targetPlanes.add(tp2);
				targetPlanes.add(tp3);
				targetPlanes.add(tp4);
				targetPlanes.add(tp5);
				targetPlanes.add(tp6);
				targetPlanes.add(tp7);
				targetPlanes.add(tp8);
				levelManager.setCreatedTargetPlanes(targetPlanes);
				//Targets
				
				
				Rocket rocket1 = new Rocket(RocketEnum.SMALL.damage(), RocketEnum.SMALL.damageArea(), 
				50, frameWidth, 200, 4);
				Rocket rocket2 = new Rocket(RocketEnum.SMALL.damage(), RocketEnum.SMALL.damageArea(), 
						RocketEnum.SMALL.health(), frameWidth, 760, 20);
				Rocket rocket3 = new Rocket(RocketEnum.MEDIUM.damage(), RocketEnum.MEDIUM.damageArea(), 
						RocketEnum.MEDIUM.health(), frameWidth, 200, 45);
				Rocket rocket4 = new Rocket(RocketEnum.MEDIUM.damage(), RocketEnum.MEDIUM.damageArea(), 
						RocketEnum.MEDIUM.health(), frameWidth, 300, 60);
				
				List<Target> targets = new ArrayList<Target>();
				targets.add(rocket1);
				targets.add(rocket2);
				targets.add(rocket3);
				targets.add(rocket4);

				Ally ally1 = new Ally(AllyEnum.ALDERAAN_CRUISER.image(), 
						AllyEnum.ALDERAAN_CRUISER.health(), frameWidth, 500, 10);
				Ally ally2 = new Ally(AllyEnum.TOMCAT.image(), 
						AllyEnum.TOMCAT.health(), frameWidth, 300, 21);
				Ally ally3 = new Ally(AllyEnum.TOMCAT.image(), 
						AllyEnum.TOMCAT.health(), frameWidth, 240, 38);
				
				targets.add(ally1);
				targets.add(ally2);
				targets.add(ally3);
				
				Carriage carriage1 = new Carriage(CarriageEnum.SMALL.health(), frameWidth, 450, 5);
				Carriage carriage2 = new Carriage(CarriageEnum.MEDIUM.health(), frameWidth, 1430, 17);
				Carriage carriage3 = new Carriage(CarriageEnum.LARGE.health(), frameWidth, 680, 28);
				Carriage carriage4 = new Carriage(CarriageEnum.LARGE.health(), frameWidth, 300, 40);
				targets.add(carriage1);
				targets.add(carriage2);
				targets.add(carriage3);
				targets.add(carriage4);
				
				levelManager.setCreatedTargets(targets);
			
				
				Obstacle obs1 = new Obstacle( ImageConstants.cityObstacleImage2, frameWidth, 1400, 20);
				obs1.setScaledImage(300);
				List<Obstacle> obstacles = new ArrayList<Obstacle>();
				obstacles.add(obs1);
				
				levelManager.setCreatedObstacles(obstacles);
				
				HealthBonusPackage bp1 = new HealthBonusPackage(50, frameWidth, 1250, 10);
				HealthBonusPackage bp2 = new HealthBonusPackage(80, frameWidth, 1000, 22);
				HealthTrapPackage bp3 = new HealthTrapPackage(50, frameWidth, 880, 30);
				HealthTrapPackage bp4 = new HealthTrapPackage(30, frameWidth, 540, 18);
				CoinPackage bp5 = new CoinPackage(10, frameWidth, 1000, 38);
				
				List<BonusPackage> bonusPackages = new ArrayList<BonusPackage>();
				bonusPackages.add(bp1);
				bonusPackages.add(bp2);
				bonusPackages.add(bp3);
				bonusPackages.add(bp4);
				bonusPackages.add(bp5);
				levelManager.setCreatedBonusPackages(bonusPackages); 
				
	
			}
			else if( levelId == 3 ){
				levelManager.setLevelTimePeriod(20);
				levelManager.setLevelPointThreshold(10);
				levelManager.setCoinCoefficient(10);
				
				//Target Planes
				TargetPlane tp = new TargetPlane(TargetPlaneEnum.REPUBLIC_ATTACK.image(), TargetPlaneEnum.REPUBLIC_ATTACK.health(),frameWidth, 300, 1,  TargetPlaneEnum.REPUBLIC_ATTACK.shoot());
				TargetPlane tp2 = new TargetPlane(TargetPlaneEnum.IMPERIAL_SHUTTLE.image(), TargetPlaneEnum.IMPERIAL_SHUTTLE.health(),frameWidth, 1500, 8,  TargetPlaneEnum.IMPERIAL_SHUTTLE.shoot());
				
				List<TargetPlane> targetPlanes = new ArrayList<TargetPlane>();
				
				targetPlanes.add(tp);
				targetPlanes.add(tp2);
				levelManager.setCreatedTargetPlanes(targetPlanes);
				//Targets
				
				Rocket rocket1 = new Rocket(RocketEnum.SMALL.damage(), RocketEnum.SMALL.damageArea(), 
				50, frameWidth, 850, 4);

				List<Target> targets = new ArrayList<Target>();
				targets.add(rocket1);

				Ally ally1 = new Ally(AllyEnum.SAAB_GRIPEN.image(), 
						AllyEnum.SAAB_GRIPEN.health(), frameWidth, 700, 11);
				
				targets.add(ally1);
				
				Carriage carriage1 = new Carriage(CarriageEnum.SMALL.health(), frameWidth, 1050, 0);
				Carriage carriage2 = new Carriage(CarriageEnum.LARGE.health(), frameWidth, 280, 8);
				Carriage carriage3 = new Carriage(CarriageEnum.LARGE.health(), frameWidth, 670, 13);
				targets.add(carriage1);
				targets.add(carriage2);
				targets.add(carriage3);
				
				levelManager.setCreatedTargets(targets);
			
				Obstacle obs1 = new Obstacle( ImageConstants.sandObstacleImage, frameWidth, 1300, 10);
				obs1.setScaledImage(500);
				List<Obstacle> obstacles = new ArrayList<Obstacle>();
				obstacles.add(obs1);
				levelManager.setCreatedObstacles(obstacles);
				
				HealthBonusPackage bp1 = new HealthBonusPackage(50, frameWidth, 250, 10);
				
				List<BonusPackage> bonusPackages = new ArrayList<BonusPackage>();
				bonusPackages.add(bp1);
				levelManager.setCreatedBonusPackages(bonusPackages); 
				
				
			}
			else if( levelId == 4 ){
				levelManager.setLevelTimePeriod(25);
				levelManager.setLevelPointThreshold(100);
				levelManager.setCoinCoefficient(50);
				
				TargetPlane tp1 = new TargetPlane(TargetPlaneEnum.REPUBLIC_ATTACK.image(), TargetPlaneEnum.REPUBLIC_ATTACK.health(),frameWidth, 690, 0,  TargetPlaneEnum.REPUBLIC_ATTACK.shoot());
				TargetPlane tp2 = new TargetPlane(TargetPlaneEnum.HAVOC_MARAUDER.image(), TargetPlaneEnum.HAVOC_MARAUDER.health(),frameWidth, 1400,12,  TargetPlaneEnum.HAVOC_MARAUDER.shoot());
				List<TargetPlane> targetPlanes = new ArrayList<TargetPlane>();
				targetPlanes.add(tp1);
				targetPlanes.add(tp2);
				
				levelManager.setCreatedTargetPlanes(targetPlanes);
				//Targets
				
				Rocket rocket1 = new Rocket(RocketEnum.MEDIUM.damage(), RocketEnum.MEDIUM.damageArea(), 
						RocketEnum.MEDIUM.health(), frameWidth, 200, 11);
				
				List<Target> targets = new ArrayList<Target>();
				targets.add(rocket1);
			
				
				Carriage carriage1 = new Carriage(CarriageEnum.SMALL.health(), frameWidth, 450, 5);
				Carriage carriage2 = new Carriage(CarriageEnum.MEDIUM.health(), frameWidth, 1430, 9);
	
				targets.add(carriage1);
				targets.add(carriage2);
				
				levelManager.setCreatedTargets(targets);
			
				
				Obstacle obs1 = new Obstacle( ImageConstants.iceObstacleImage, frameWidth, 1000, 14);
				
				List<Obstacle> obstacles = new ArrayList<Obstacle>();
				obstacles.add(obs1);
				
				levelManager.setCreatedObstacles(obstacles);
				
				HealthBonusPackage bp1 = new HealthBonusPackage(50, frameWidth, 250, 5);
				HealthTrapPackage bp2 = new HealthTrapPackage(50, frameWidth, 880, 10);
				
				List<BonusPackage> bonusPackages = new ArrayList<BonusPackage>();
				bonusPackages.add(bp1);
				bonusPackages.add(bp2);
				
				levelManager.setCreatedBonusPackages(bonusPackages); 
				
				
			}
			else if( levelId == 5 ){
				levelManager.setLevelTimePeriod(60);
				levelManager.setLevelPointThreshold(1500);
				levelManager.setCoinCoefficient(50);
				
				TargetPlane tp = new TargetPlane(TargetPlaneEnum.F16.image(), TargetPlaneEnum.F16.health(),frameWidth, 800, 0,  TargetPlaneEnum.F16.shoot());
				TargetPlane tp2 = new TargetPlane(TargetPlaneEnum.IMPERIAL_SHUTTLE.image(), TargetPlaneEnum.IMPERIAL_SHUTTLE.health(),frameWidth,500, 2,  TargetPlaneEnum.IMPERIAL_SHUTTLE.shoot());
				TargetPlane tp3 = new TargetPlane(TargetPlaneEnum.F16.image(), TargetPlaneEnum.F16.health(), frameWidth,1500,5, TargetPlaneEnum.F16.shoot());
				TargetPlane tp4 = new TargetPlane(TargetPlaneEnum.REPUBLIC_ATTACK.image(), TargetPlaneEnum.REPUBLIC_ATTACK.health(),frameWidth,1000,15,  TargetPlaneEnum.REPUBLIC_ATTACK.shoot());
				TargetPlane tp5 = new TargetPlane(TargetPlaneEnum.HAVOC_MARAUDER.image(), TargetPlaneEnum.HAVOC_MARAUDER.health(),frameWidth,800,26,  TargetPlaneEnum.HAVOC_MARAUDER.shoot());
				TargetPlane tp6 = new TargetPlane(TargetPlaneEnum.F16.image(), TargetPlaneEnum.F16.health(), frameWidth, 1320, 37,  TargetPlaneEnum.F16.shoot());
				TargetPlane tp7 = new TargetPlane(TargetPlaneEnum.BOSS.image(), TargetPlaneEnum.BOSS.health(), frameWidth , 500, 50,  TargetPlaneEnum.BOSS.shoot());
				tp7.setScaledImage(500);
				List<TargetPlane> targetPlanes = new ArrayList<TargetPlane>();
				targetPlanes.add(tp);
				targetPlanes.add(tp2);
				targetPlanes.add(tp3);
				targetPlanes.add(tp4);
				targetPlanes.add(tp5);
				targetPlanes.add(tp6);
				targetPlanes.add(tp7);
				
				levelManager.setCreatedTargetPlanes(targetPlanes);
				//Targets
				
				
				Rocket rocket1 = new Rocket(RocketEnum.SMALL.damage(), RocketEnum.SMALL.damageArea(), 
				50, frameWidth, 200, 4);
				Rocket rocket2 = new Rocket(RocketEnum.SMALL.damage(), RocketEnum.SMALL.damageArea(), 
						RocketEnum.SMALL.health(), frameWidth, 760, 18);
				Rocket rocket3 = new Rocket(RocketEnum.MEDIUM.damage(), RocketEnum.MEDIUM.damageArea(), 
						RocketEnum.MEDIUM.health(), frameWidth, 200, 30);
				Rocket rocket4 = new Rocket(RocketEnum.MEDIUM.damage(), RocketEnum.MEDIUM.damageArea(), 
						RocketEnum.MEDIUM.health(), frameWidth, 1000, 45);
				
				List<Target> targets = new ArrayList<Target>();
				targets.add(rocket1);
				targets.add(rocket2);
				targets.add(rocket3);
				targets.add(rocket4);

				Ally ally2 = new Ally(AllyEnum.WUNDERWAFFE.image(), 
						AllyEnum.WUNDERWAFFE.health(), frameWidth, 1500, 35);
				Ally ally3 = new Ally(AllyEnum.TOMCAT.image(), 
						AllyEnum.TOMCAT.health(), frameWidth, 240, 50);
				
				targets.add(ally2);
				targets.add(ally3);
				
				Carriage carriage1 = new Carriage(CarriageEnum.SMALL.health(), frameWidth,670, 5);
				Carriage carriage2 = new Carriage(CarriageEnum.MEDIUM.health(), frameWidth, 200, 17);
				Carriage carriage3 = new Carriage(CarriageEnum.LARGE.health(), frameWidth, 1290, 28);
				Carriage carriage4 = new Carriage(CarriageEnum.LARGE.health(), frameWidth, 300, 40);
				targets.add(carriage1);
				targets.add(carriage2);
				targets.add(carriage3);
				targets.add(carriage4);
				
				levelManager.setCreatedTargets(targets);
			
				Obstacle obs1 = new Obstacle( ImageConstants.fieldObstacleImage, frameWidth, 800, 20);
				
				List<Obstacle> obstacles = new ArrayList<Obstacle>();
				obstacles.add(obs1);
				levelManager.setCreatedObstacles(obstacles);
				
				HealthBonusPackage bp1 = new HealthBonusPackage(50, frameWidth, 250, 10);
				HealthBonusPackage bp2 = new HealthBonusPackage(80, frameWidth, 400, 22);
				HealthTrapPackage bp3 = new HealthTrapPackage(50, frameWidth, 880, 30);
				HealthTrapPackage bp4 = new HealthTrapPackage(30, frameWidth, 540, 18);
				CoinPackage bp5 = new CoinPackage(10, frameWidth, 740, 38);
				
				List<BonusPackage> bonusPackages = new ArrayList<BonusPackage>();
				bonusPackages.add(bp1);
				bonusPackages.add(bp2);
				bonusPackages.add(bp3);
				bonusPackages.add(bp4);
				bonusPackages.add(bp5);
				levelManager.setCreatedBonusPackages(bonusPackages); 
				
				
			}
			
	}
}
