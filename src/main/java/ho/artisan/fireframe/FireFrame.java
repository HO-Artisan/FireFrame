package ho.artisan.fireframe;

import com.dm.earth.tags_binder.api.LoadTagsCallback;
import ho.artisan.fireframe.tags.Tags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.entity.event.api.ServerEntityTickCallback;

import java.util.ArrayList;
import java.util.List;

public class FireFrame implements ModInitializer {
	@Override
	public void onInitialize(ModContainer mod) {
		LoadTagsCallback.ITEM.register(handler -> {
			List<Item> list = new ArrayList<>();
			list.add(Items.BLAZE_ROD);
			list.add(Items.BLAZE_POWDER);
			list.add(Items.MAGMA_CREAM);
			list.add(Items.MAGMA_BLOCK);
			list.forEach(item -> {
				handler.register(Tags.heatItemTag, item);
			});
		});

		ServerEntityTickCallback.EVENT.register((entity, isPassengerTick) -> {
			if (entity instanceof PlayerEntity player) {
				ItemStack offHandStack = player.getOffHandStack();
				ItemStack mainHandStack = player.getMainHandStack();
				if (offHandStack.isIn(Tags.heatItemTag) || mainHandStack.isIn(Tags.heatItemTag)) {
					player.setOnFireFor(5);
				}
			}
		});
	}
}
