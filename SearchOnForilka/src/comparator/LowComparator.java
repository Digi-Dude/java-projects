package comparator;

import products.Product;

import java.util.Comparator;

public class LowComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o2.getPrice(), o1.getPrice());
    }
}



//    public List<Employee> getLowestSalaryStaff(int count) {
//        staff.sort(new LowComparator());
//        List<Employee> list = new ArrayList<>();
//        if (isValidCount(count)) {
//            for (int i = 0; i < count; i++) {
//                list.add(staff.get(i));
//            }
//            return list;
//        }
//        else return Collections.EMPTY_LIST;
//    }
//
