package lib;

public class TaxFunction {

    /**
     * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
     *
     * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
     *
     * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
     * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
     * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
     *
     */


    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {

        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
            numberOfMonthWorking = 12;
        }

        numberOfChildren = Math.min(numberOfChildren, 3);

        int annualSalary = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;

        int taxExemptIncome = calculateTaxExemptIncome(isMarried, numberOfChildren);

        int tax = calculateTaxAmount(annualSalary, deductible, taxExemptIncome);

        return Math.max(tax, 0);
    }

    private static int calculateTaxAmount(int annualSalary, int deductible, int taxExemptIncome) {
        return (int) Math.round(0.05 * (annualSalary - deductible - taxExemptIncome));
    }

    private static int calculateTaxExemptIncome(boolean isMarried, int numberOfChildren) {
        int taxExemptIncome = 54000000;

        if (isMarried) {
            taxExemptIncome += 4500000;
        }

        taxExemptIncome += numberOfChildren * 1500000;
        return taxExemptIncome;
    }
}
