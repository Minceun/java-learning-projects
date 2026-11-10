package home6;

public	class RectangleAreaComparator implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			if(((GeometricObject)o1).getArea()<((GeometricObject)o2).getArea())
			{
				return -1;
			}
			else if(((GeometricObject)o1).getArea()>((GeometricObject)o2).getArea())
			{
				return 1;
			}else
			{
				return 0;
			}
		}
	}
}
}
