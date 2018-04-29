
public abstract class IconShape {
	private String color;

	// 得出面积
	public abstract double iconArea();

	// 得出形状
	public abstract String getType();

	// 用于设置/获取 颜色属性的方法
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
