package com.example.uidemo;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.InputType;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ArrayList<NhanVien> dsNhanVien;
    private String[] dsDonVi;
    private String donVi;
    private Button btnThoat;
    private EditText edtMa;
    private EditText edtHoTen;
    private RadioButton rdoNam;
    private RadioButton rdoNu;
    private RadioGroup radioGroup;
    private ImageView imvAnh;
    private Button btnXoa;
    private Button btnThem;
    private Button btnTruyVan;
    private Spinner spinner;
    private ListView listView;
    private Button btnChoose;
    private Uri uri;
    private Button btnSua;
    private Button btnGhi;
    private Button btnDoc;
    private int index = -2;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verifyStoragePermissions(MainActivity.this);
        dsNhanVien = new ArrayList<NhanVien>();
        anhXa();

        dsDonVi = getResources().getStringArray(R.array.phong_ban);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dsDonVi);
        spinner.setAdapter(adapter);
        NhanVienAdapter nhanVienAdapter = new NhanVienAdapter(this, dsNhanVien, R.layout.dong_nhan_vien);
//        ArrayAdapter nhanVienAdt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dsNhanVien);
        listView.setAdapter(nhanVienAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donVi = dsDonVi[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    dsNhanVien= readFile("nhanvien.txt");
                    nhanVienAdapter.updateListView(dsNhanVien);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtHoTen.getText().toString().trim();
                boolean gt = rdoNam.isChecked();
                NhanVien nhanVien = new NhanVien(dsNhanVien.get(index).getMa(), ten, gt, donVi, uri);
                dsNhanVien.set(index, nhanVien);
                nhanVienAdapter.updateListView(dsNhanVien);
            }
        });
        btnTruyVan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final EditText text = new EditText(MainActivity.this);
                text.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(text);
                builder.setTitle("Nhập").setMessage("Nhập vào mã nhân viên muốn ").setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int viTri = Integer.parseInt(text.getText().toString());
                        NhanVien nhanVien = null;
                        for (NhanVien nv : dsNhanVien
                        ) {
                            if (nv.getMa() == viTri) {
                                nhanVien = nv;
                                break;
                            }
                        }
                        if (nhanVien == null)
                            Toast.makeText(MainActivity.this, "không tìm thấy nhân viên nào", Toast.LENGTH_SHORT).show();
                        else {

                            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                            builder1.setTitle("kết quả truy vấn");
                            builder1.setMessage(nhanVien.toString());
                            Dialog dialog1 = builder1.create();
                            dialog1.show();
                            Toast.makeText(MainActivity.this, "tìm thấy nhân viên:" + nhanVien + ", ở vị trí thứ" + dsNhanVien.indexOf(nhanVien), Toast.LENGTH_LONG).show();
                        }

                    }
                }).setNegativeButton("hủy bỏ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận").setMessage("Bạn có chắc xóa dòng này").setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dsNhanVien.remove(index);
                        nhanVienAdapter.updateListView(dsNhanVien);
                    }
                }).setNegativeButton("hủy bỏ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ma = Integer.parseInt(edtMa.getText().toString().trim());
                String ten = edtHoTen.getText().toString().trim();
                boolean gt = rdoNam.isChecked();
                NhanVien nhanVien = new NhanVien(ma, ten, gt, donVi, uri);
                if (!dsNhanVien.contains(nhanVien)) {
                    boolean add = dsNhanVien.add(nhanVien);
                    nhanVienAdapter.updateListView(dsNhanVien);
                } else {
                    Toast.makeText(MainActivity.this, "Nhân viên này đã tồn tại", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Title"), 1);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (index != i) {
                    if (index >= 0 && index < dsNhanVien.size()) {
                        adapterView.getChildAt(index).setBackgroundColor(Color.WHITE);
                    }
                    view.setBackgroundColor(Color.BLUE);
                    index = i;
                }
                TextView ma = view.findViewById(R.id.tvMa);
                TextView ten = view.findViewById(R.id.tvTen);
                TextView gt = view.findViewById(R.id.tvGt);
                TextView dv = view.findViewById(R.id.tvDonVi);
                ImageView hinh = view.findViewById(R.id.imvHinh);
                edtMa.setText(ma.getText().toString());
                edtHoTen.setText(ten.getText().toString());
                if (gt.getText().toString().equals("Nam")) {
                    rdoNu.setChecked(false);
                    rdoNam.setChecked(true);
                } else {
                    rdoNu.setChecked(true);
                    rdoNam.setChecked(false);
                }
                Bitmap bitmap = convertImageViewToBitmap(hinh);
                imvAnh.setImageBitmap(bitmap);

            }
        });
        btnGhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    save("nhanvien.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private Bitmap convertImageViewToBitmap(ImageView v) {
        Bitmap bm = ((BitmapDrawable) v.getDrawable()).getBitmap();
        return bm;
    }
    public Bitmap convertUriToBitmap(Uri uri) throws FileNotFoundException {
        ParcelFileDescriptor parcelFileDescriptor=getContentResolver().openFileDescriptor(uri,"r");
        FileDescriptor fileDescriptor=parcelFileDescriptor.getFileDescriptor();
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            uri = data.getData();
            Log.println(Log.INFO,"Infor:",uri.toString()+","+uri.getEncodedPath());
            try {
                Bitmap bitmap=MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
                Log.println(Log.INFO,"Infor:",bitmap+","+bitmap.toString());
                imvAnh.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

    public void save(String filename) throws IOException {

        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File myFile = new File(folder, filename);
            String s = "";
            for (NhanVien nhanVien : dsNhanVien) {
                s += nhanVien.toString();
            }
            FileOutputStream fstream = new FileOutputStream(myFile);

            fstream.write(s.getBytes());
            fstream.close();
        } else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            // Đọc được, không ghi được
        } else {
            // Kh
        }
    }

    public ArrayList<NhanVien> readFile(String fileName) throws IOException {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, fileName);
        FileInputStream in = new FileInputStream(file);
        int i;
        StringBuffer s = new StringBuffer();
        while ((i = in.read()) != -1) {
            s.append((char) i);
        }
        ArrayList<NhanVien> staffs = new ArrayList<NhanVien>();
        in.close();
        String[] dsnv = s.toString().split(";");
        Log.println(Log.INFO, "Nhan vien", dsnv[0] + "\n" + dsnv[1]);
        for (String nv : dsnv) {
            String[] temp = nv.split(",");
            Bitmap bitmap;
            NhanVien nhanVien = new NhanVien(Integer.parseInt(temp[0]), temp[1], Boolean.parseBoolean(temp[2]), temp[3],Uri.parse(temp[4].trim()));
            staffs.add(nhanVien);

        }
        return staffs;
    }


    private void anhXa() {
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnTruyVan = findViewById(R.id.btnTruyVan);
        btnThoat = findViewById(R.id.btnThoat);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtMa = findViewById(R.id.edtMa);
        radioGroup = findViewById(R.id.rdoGioiTinh);
        spinner = findViewById(R.id.spnDonVi);
        listView = findViewById(R.id.lv);
        rdoNam = findViewById(R.id.rdoNam);
        rdoNu = findViewById(R.id.rdoNu);
        imvAnh = findViewById(R.id.imvAnh);
        btnChoose = findViewById(R.id.btnChoose);
        btnSua = findViewById(R.id.btnSua);
        btnGhi = findViewById(R.id.btnGhi);
        btnDoc = findViewById(R.id.btnDoc);
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


}