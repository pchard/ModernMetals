package modernmetals.init;

import modernmetals.ModernMetals;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

/** initializer for achievements */
public abstract class Achievements {
	
	public static AchievementPage page;

	public static Achievement aluminumbrass_maker; // make blend
	public static Achievement titanium_maker; // make blend
	
	
	
	private static boolean initDone = false;
	public static void init(){
		if(initDone)return;
		
		page = new AchievementPage(ModernMetals.NAME);
		AchievementPage.registerAchievementPage(page);
		
		aluminumbrass_maker = makeAchievement("aluminumbrass_maker",cyano.basemetals.init.Achievements.metallurgy,0,0,Items.aluminumbrass_ingot);
		titanium_maker = makeAchievement("titanium_maker",cyano.basemetals.init.Achievements.metallurgy,0,1,Items.titanium_ingot);
		
		
		initDone = true;
	}
	private static Achievement makeAchievement(String baseName, Achievement requirement, int x, int y, Item icon) {
		return makeAchievement( baseName,  requirement,  x,  y, new ItemStack( icon));
	}
	private static Achievement makeAchievement(String baseName, Achievement requirement, int x, int y, Block icon) {
		return makeAchievement( baseName,  requirement,  x,  y, new ItemStack( icon));
	}
	private static Achievement makeAchievement(String baseName, Achievement requirement, int x, int y, ItemStack icon) {
		Achievement a = new Achievement(baseName,baseName,x,y,icon,requirement);
		a.registerStat();
		page.getAchievements().add(a);
		return a;
	}
	
}