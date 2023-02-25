package ho.artisan.fireframe.tags;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class Tags {
	public static final TagKey<Item> heatItemTag = item("heat_item");

	public static TagKey<Item> item(String id) {
		return TagKey.of(RegistryKeys.ITEM, new Identifier(id));
	}
}
