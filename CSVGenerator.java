import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVGenerator {
    public static void main(String[] args) {
        String[] header = {"Product Name", "Product Price", "Item Number", "Model Number", "Product Category", "Product Description"};
        String[][] products = {
                {"Apple AirPods Pro", "$179", "SKU-001", "Model-001", "Electronics", "Active noise cancellation for immersive sound"},
                {"Mainstays 5-Piece Glass Top Metal Dining Set", "$149", "SKU-002", "Model-002", "Furniture", "Includes 4 chairs and a glass top table"},
                {"Keurig K-Compact Single-Serve K-Cup Pod Coffee Maker", "$59", "SKU-003", "Model-003", "Appliances", "Brews multiple cup sizes with a 36 oz. water reservoir"},
                {"Roku Streaming Stick+", "$49", "SKU-004", "Model-004", "Electronics", "HD, 4K, and HDR streaming with voice remote and TV controls"},
                {"Fitbit Inspire 2 Health & Fitness Tracker", "$68", "SKU-005", "Model-005", "Sports & Outdoors", "24/7 heart rate monitoring and up to 10 days of battery life"},
                {"Ninja Foodi 4-in-1 Indoor Grill", "$169", "SKU-006", "Model-006", "Appliances", "Grill, air fry, bake, and dehydrate all in one appliance"},
                {"Black+Decker Cordless Handheld Vacuum", "$59", "SKU-007", "Model-007", "Home Improvement", "Dustbin capacity of 20.6 ounces and strong suction power"},
                {"Huffy 26-inch Cranbrook Men's Cruiser Bike", "$129", "SKU-008", "Model-008", "Outdoor Recreation", "Classic cruiser-style bike with rear coaster brakes"},
                {"Essentials by OFM Racing Style Gaming Chair", "$99", "SKU-009", "Model-009", "Office Supplies", "Adjustable seat height and backrest with lumbar support"},
                {"Better Homes & Gardens 4-Cube Storage Organizer", "$44", "SKU-010", "Model-010", "Home", "Versatile storage solution for any room in your home"}
        };

        // Write product details to CSV file
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(new File("walmart-products.csv"));
            // Write header row
            for (int i = 0; i < header.length; i++) {
                csvWriter.append(header[i]);
                if (i != header.length - 1) {
                    csvWriter.append(",");
                }
            }
            csvWriter.append("\n");

            // Write product details rows
            for (String[] product : products) {
                for (int i = 0; i < product.length; i++) {
                    csvWriter.append(product[i]);
                    if (i != product.length - 1) {
                        csvWriter.append(",");
                    }
                }
                csvWriter.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                csvWriter.flush();
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
