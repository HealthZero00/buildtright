package com.example.building3

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.building3.CPU.CPUAdapterWithoutURL
import com.example.building3.CPU.CPUWITHOUTURL
import com.example.building3.Corpus.CORPUSWITHOUTURL
import com.example.building3.Corpus.CorpusAdapterWithoutURL
import com.example.building3.CpuCooler.CPUCOOLERWITHOUTURL
import com.example.building3.CpuCooler.CpucoolerAdapterWithoutURL
import com.example.building3.Databases.BuildDatabase
import com.example.building3.Databases.BuildEntity
import com.example.building3.GPU.GPU
import com.example.building3.GPU.GPUAdapterWithoutURL
import com.example.building3.GPU.GPUWITHOUTURL
import com.example.building3.Motherboards.MOTHERBOARDS
import com.example.building3.Motherboards.MOTHERBOARDSAdapterWithoutURL
import com.example.building3.Motherboards.MOTHERBOARDSWITHOUTURL
import com.example.building3.Powersupplies.POWERSUPPLIES
import com.example.building3.Powersupplies.POWERSUPPLIESWITHOUTURL
import com.example.building3.Powersupplies.PowersuppliesAdapterWithoutURL
import com.example.building3.RAM.RAMAdapterWithoutURL
import com.example.building3.RAM.RAMWITHOUTURL
import com.example.building3.SSD.SSDAdapterWithoutURL
import com.example.building3.SSD.SSDWITHOUTURL
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
class AddConfFragment : Fragment() {
    private lateinit var componentsRecyclerView: RecyclerView
    private lateinit var selectMotherboardButton: Button
    private lateinit var selectedMotherboardTextView: TextView
    private lateinit var selectCpuButton: Button
    private lateinit var selectGpuButton: Button
    private lateinit var selectPowersupplyButton: Button
    private lateinit var selectRAMButton: Button
    private lateinit var selectSSDButton: Button
    private lateinit var selectCpucoolerButton: Button
    private lateinit var selectCorpusButton: Button  // Новая кнопка для выбора корпуса
    private lateinit var selectedCpuTextView: TextView
    private lateinit var selectedGpuTextView: TextView
    private lateinit var selectedPowersupplyTextView: TextView
    private lateinit var selectedRAMTextView: TextView
    private lateinit var selectedSSDTextView: TextView
    private lateinit var selectedCpucoolerTextView: TextView
    private lateinit var selectedCorpusTextView: TextView  // Новое поле для отображения выбранного корпуса

    private lateinit var motherboardAdapter: MOTHERBOARDSAdapterWithoutURL
    private lateinit var cpuAdapter: CPUAdapterWithoutURL
    private lateinit var gpuAdapter: GPUAdapterWithoutURL
    private lateinit var powersupplyAdapter: PowersuppliesAdapterWithoutURL
    private lateinit var ramAdapter: RAMAdapterWithoutURL
    private lateinit var ssdAdapter: SSDAdapterWithoutURL
    private lateinit var cpucoolerAdapter: CpucoolerAdapterWithoutURL
    private lateinit var corpusAdapter: CorpusAdapterWithoutURL  // Новый адаптер для корпусов

    private var selectedMotherboard: MOTHERBOARDSWITHOUTURL? = null
    private var selectedCpu: CPUWITHOUTURL? = null
    private var selectedGpu: GPUWITHOUTURL? = null
    private var selectedPowersupplies: POWERSUPPLIESWITHOUTURL? = null
    private var selectedRAM: RAMWITHOUTURL? = null
    private var selectedSSD: SSDWITHOUTURL? = null
    private var selectedCpucooler: CPUCOOLERWITHOUTURL? = null
    private var selectedCorpus: CORPUSWITHOUTURL? = null  // Новая переменная для выбранного корпуса

    private var allCPUs: List<CPUWITHOUTURL> = getCPUs()
    private var allGPUs: List<GPUWITHOUTURL> = getGPUs()
    private var allMotherboards: List<MOTHERBOARDSWITHOUTURL> = getMotherboards()
    private var allPowersupplies: List<POWERSUPPLIESWITHOUTURL> = getPowersupplies()
    private var allRAM: List<RAMWITHOUTURL> = getRAMs()
    private var allSSDs: List<SSDWITHOUTURL> = getSSDs()
    private var allCpucoolers: List<CPUCOOLERWITHOUTURL> = getCpucoolers()
    private var allCorpus: List<CORPUSWITHOUTURL> = getCorpus()  // Новый список корпусов
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_conf, container, false)

        componentsRecyclerView = view.findViewById(R.id.componentsRecyclerView)
        selectMotherboardButton = view.findViewById(R.id.selectMotherboardButton)
        selectedMotherboardTextView = view.findViewById(R.id.selectedMotherboardTextView)
        selectedGpuTextView = view.findViewById(R.id.selectedGpuTextView)
        selectCpuButton = view.findViewById(R.id.selectCpuButton)
        selectedCpuTextView = view.findViewById(R.id.selectedCpuTextView)
        selectedRAMTextView = view.findViewById(R.id.selectedRAMTextView)
        selectGpuButton = view.findViewById(R.id.selectGpuButton)
        selectRAMButton = view.findViewById(R.id.selectRAMButton)
        selectPowersupplyButton = view.findViewById(R.id.selectPowersuppliesButton)
        selectedPowersupplyTextView = view.findViewById(R.id.selectedPowersuppliesTextView)
        selectedSSDTextView = view.findViewById(R.id.selectedSSDTextView)
        selectSSDButton = view.findViewById(R.id.selectSSDButton)
        selectCpucoolerButton = view.findViewById(R.id.selectCpucoolerButton)
        selectedCpucoolerTextView = view.findViewById(R.id.selectedCpucoolerTextView)
        selectCorpusButton =
            view.findViewById(R.id.selectCorpusButton)  // Новая кнопка для выбора корпуса
        selectedCorpusTextView =
            view.findViewById(R.id.selectedCorpusTextView)  // Новое поле для отображения выбранного корпуса

        motherboardAdapter = MOTHERBOARDSAdapterWithoutURL(allMotherboards)
        cpuAdapter = CPUAdapterWithoutURL(allCPUs)
        gpuAdapter = GPUAdapterWithoutURL(allGPUs)
        powersupplyAdapter = PowersuppliesAdapterWithoutURL(allPowersupplies)
        ramAdapter = RAMAdapterWithoutURL(allRAM)
        ssdAdapter = SSDAdapterWithoutURL(allSSDs)
        cpucoolerAdapter = CpucoolerAdapterWithoutURL(allCpucoolers)
        corpusAdapter = CorpusAdapterWithoutURL(allCorpus)  // Новый адаптер для корпусов

        componentsRecyclerView.layoutManager = LinearLayoutManager(context)
        componentsRecyclerView.adapter = motherboardAdapter


        selectMotherboardButton.setOnClickListener {
            showMotherboardSelectionDialog()
        }

        motherboardAdapter.setOnItemClickListener(object :
            MOTHERBOARDSAdapterWithoutURL.OnItemClickListener {
            override fun onItemClick(position: Int) {
                selectedMotherboard = motherboardAdapter.getItem(position)
                updateSelectedMotherboardTextView()
                updateCompatibleCPUList()
                updateCompatibleRAMList()
            }
        })

        selectCpuButton.setOnClickListener {
            showCpuSelectionDialog()
        }

        cpuAdapter.setOnItemClickListener(object : CPUAdapterWithoutURL.OnItemClickListener {
            override fun onItemClick(position: Int) {
                selectedCpu = cpuAdapter.getItem(position)
                updateSelectedCpuTextView()
                updateCompatibleMotherboardList()
                updateCompatibleRAMList()
            }




        })


        selectGpuButton.setOnClickListener {
            showGpuSelectionDialog()
        }

        selectPowersupplyButton.setOnClickListener {
            showPowersuppliesSelectionDialog()
        }

        selectRAMButton.setOnClickListener {
            showRAMSelectionDialog()
        }

        selectSSDButton.setOnClickListener {
            showSSDSelectionDialog()
        }

        selectCpucoolerButton.setOnClickListener {
            showCpucoolerSelectionDialog()
        }

        selectCorpusButton.setOnClickListener {
            showCorpusSelectionDialog()
        }

        gpuAdapter.setOnItemClickListener(object : GPUAdapterWithoutURL.OnItemClickListener {
            override fun onItemClick(position: Int) {
                selectedGpu = gpuAdapter.getItem(position)
                updateSelectedGpuTextView()
            }


        })

        powersupplyAdapter.setOnItemClickListener(object :
            PowersuppliesAdapterWithoutURL.OnItemClickListener {
            override fun onItemClick(position: Int) {
                selectedPowersupplies = powersupplyAdapter.getItem(position)
                updateSelectedPowersuppliesTextView()
            }


        })

        ramAdapter.setOnItemClickListener(object : RAMAdapterWithoutURL.OnItemClickListener {
            override fun onItemClick(position: Int) {
                selectedRAM = ramAdapter.getItem(position)
                updateSelectedRAMTextView()
                updateCompatibleMotherboardList()
                updateCompatibleCPUList()

            }


        })

        ssdAdapter.setOnItemClickListener(object : SSDAdapterWithoutURL.OnItemClickListener {
            override fun onItemClick(position: Int) {
                selectedSSD = ssdAdapter.getItem(position)
                updateSelectedSSDTextView()
                updateCompatibleMotherboardList()
                updateCompatibleCPUList()
                updateSelectedRAMTextView()
            }


        })

        cpucoolerAdapter.setOnItemClickListener(object :
            CpucoolerAdapterWithoutURL.OnItemClickListener {
            override fun onItemClick(position: Int) {
                selectedCpucooler = cpucoolerAdapter.getItem(position)
                updateSelectedCpucoolerTextView()
            }


        })

        corpusAdapter.setOnItemClickListener(object : CorpusAdapterWithoutURL.OnItemClickListener {
            override fun onItemClick(position: Int) {
                selectedCorpus = corpusAdapter.getItem(position)
                updateSelectedCorpusTextView()
            }


        })




        return view
    }

    private fun showMotherboardSelectionDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Выберите материнскую плату")

        val motherboardNames = motherboardAdapter.getMotherboardNames().toTypedArray()
        val selectedMotherboardIndex = motherboardAdapter.getSelectedMotherboardIndex()

        builder.setSingleChoiceItems(motherboardNames, selectedMotherboardIndex) { dialog, which ->
            selectedMotherboard = motherboardAdapter.getItem(which)
            updateSelectedMotherboardTextView()
            updateCompatibleCPUList()
            dialog.dismiss()
        }

        builder.setNegativeButton("Отмена") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    private fun showCpuSelectionDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Выберите процессор")

        val cpuNames = cpuAdapter.getCpuNames().toTypedArray()
        val selectedCpuIndex = cpuAdapter.getSelectedCpuIndex()

        builder.setSingleChoiceItems(cpuNames, selectedCpuIndex) { dialog, which ->
            selectedCpu = cpuAdapter.getItem(which)
            updateSelectedCpuTextView()
            updateCompatibleMotherboardList()
            dialog.dismiss()
        }

        builder.setNegativeButton("Отмена") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    private fun showGpuSelectionDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Выберите видеокарту")

        val gpuNames = gpuAdapter.getGPUNames().toTypedArray()
        val selectedGpuIndex = gpuAdapter.getSelectedGPUIndex()

        builder.setSingleChoiceItems(gpuNames, selectedGpuIndex) { dialog, which ->
            selectedGpu = gpuAdapter.getItem(which)
            updateSelectedGpuTextView()
            dialog.dismiss()
        }

        builder.setNegativeButton("Отмена") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    private fun showPowersuppliesSelectionDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Выберите блок питания")

        val powerpuppliesNames = powersupplyAdapter.getPowersuppliesName().toTypedArray()
        val selectedpowerpuppliesIndex = powersupplyAdapter.getSelectedPowersuppliesIndex()

        builder.setSingleChoiceItems(
            powerpuppliesNames,
            selectedpowerpuppliesIndex
        ) { dialog, which ->
            selectedPowersupplies = powersupplyAdapter.getItem(which)
            updateSelectedPowersuppliesTextView()
            dialog.dismiss()
        }

        builder.setNegativeButton("Отмена") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    private fun showRAMSelectionDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Выберите оперативную память")

        val RAMNames = ramAdapter.getRAMNames().toTypedArray()
        val selectedRAMIndex = ramAdapter.getSelectedRAMIndex()

        builder.setSingleChoiceItems(RAMNames, selectedRAMIndex) { dialog, which ->
            selectedRAM = ramAdapter.getItem(which)
            updateSelectedRAMTextView()
            updateCompatibleRAMList()
            dialog.dismiss()
        }

        builder.setNegativeButton("Отмена") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    private fun showSSDSelectionDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Выберите твердотельный накопитель")

        val SSDNames = ssdAdapter.getSSDNames().toTypedArray()
        val selectedSSDIndex = ssdAdapter.getSelectedSSDIndex()

        builder.setSingleChoiceItems(SSDNames, selectedSSDIndex) { dialog, which ->
            selectedSSD = ssdAdapter.getItem(which)
            updateSelectedSSDTextView()
            dialog.dismiss()
        }

        builder.setNegativeButton("Отмена") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    private fun showCpucoolerSelectionDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Выберите кулер")

        val CpucoolerNames = cpucoolerAdapter.getCpucoolerNames().toTypedArray()
        val selectedCpucoolerIndex = cpucoolerAdapter.getSelectedCpucoolerIndex()

        builder.setSingleChoiceItems(CpucoolerNames, selectedCpucoolerIndex) { dialog, which ->
            selectedCpucooler = cpucoolerAdapter.getItem(which)
            updateSelectedCpucoolerTextView()
            dialog.dismiss()
        }

        builder.setNegativeButton("Отмена") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    private fun showCorpusSelectionDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Выберите корпус")

        val CorpusNames = corpusAdapter.getCorpusNames().toTypedArray()
        val selectedCorpusIndex = corpusAdapter.getSelectedCorpusIndex()

        builder.setSingleChoiceItems(CorpusNames, selectedCorpusIndex) { dialog, which ->
            selectedCorpus = corpusAdapter.getItem(which)
            updateSelectedCorpusTextView()
            dialog.dismiss()
        }

        builder.setNegativeButton("Отмена") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }


    private fun updateSelectedMotherboardTextView() {
        selectedMotherboardTextView.text =
            selectedMotherboard?.name ?: "Материнская плата не выбрана"
        selectedMotherboardTextView.visibility = View.VISIBLE
    }

    private fun updateSelectedCpuTextView() {
        selectedCpuTextView.text = selectedCpu?.name ?: "Процессор не выбран"
        selectedCpuTextView.visibility = View.VISIBLE
    }

    private fun updateSelectedGpuTextView() {
        selectedGpuTextView.text = selectedGpu?.name ?: "Видеокарта не выбрана"
        selectedGpuTextView.visibility = View.VISIBLE
    }

    private fun updateSelectedPowersuppliesTextView() {
        selectedPowersupplyTextView.text = selectedPowersupplies?.name ?: "Блок питания не выбран"
        selectedPowersupplyTextView.visibility = View.VISIBLE
    }

    private fun updateSelectedRAMTextView() {
        selectedRAMTextView.text = selectedRAM?.name ?: "Оперативная память не выбрана"
        selectedRAMTextView.visibility = View.VISIBLE
    }

    private fun updateSelectedSSDTextView() {
        selectedSSDTextView.text = selectedSSD?.name ?: "Твердотельный накопитель не выбран"
        selectedSSDTextView.visibility = View.VISIBLE
    }

    private fun updateSelectedCpucoolerTextView() {
        selectedCpucoolerTextView.text = selectedCpucooler?.name ?: "Кулер не выбран"
        selectedCpucoolerTextView.visibility = View.VISIBLE
    }

    private fun updateSelectedCorpusTextView() {
        selectedCorpusTextView.text = selectedCorpus?.name ?: "Корпус не выбран"
        selectedCorpusTextView.visibility = View.VISIBLE
    }


    private fun updateCompatibleCPUList() {
        // Фильтрация процессоров по совместимости с выбранной материнской платой
        allCPUs = getCPUs().filter { it.socket == selectedMotherboard?.socket }
        cpuAdapter.updateList(allCPUs)
    }

    private fun updateCompatibleMotherboardList() {
        // Фильтрация процессоров по совместимости с выбранной материнской платой
        allCPUs = getCPUs().filter { it.socket == selectedMotherboard?.socket }
        cpuAdapter.updateList(allCPUs)

        if (selectedMotherboard != null) {
            updateCompatibleCPUList()
        }
    }

    private fun updateCompatibleRAMList() {
        // Фильтрация оперативной памяти по совместимости с выбранной материнской платой
        allRAM = getRAMs().filter { it.typeMemory == selectedMotherboard?.memoryType }
        ramAdapter.updateList(allRAM)
    }

    private fun updateCompatibleSSDList() {
        // Фильтрация SSD по совместимости с выбранной материнской платой и поддержкой NVMe
        allSSDs = getSSDs().filter { it.NVMestatus == selectedMotherboard?.nvmeStatus }
        ssdAdapter.updateList(allSSDs)
    }




    private fun getMotherboards(): List<MOTHERBOARDSWITHOUTURL> {
        return listOf(
            MOTHERBOARDSWITHOUTURL("Asus ROG Maximus XI Exteme", "Asus", "E-ATX", "29 999", "LGA1151-2", "Z390", "DDR4", "Yes"),
            MOTHERBOARDSWITHOUTURL("EVGA Z390 Dark", "EVGA", "E-ATX", "45 399", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Gigabyte Z390 Aorus Xtreme Waterforce", "Gigabyte", "E-ATX", "53 499", "LGA1151-2", "Z390", "DDR4", "Yes"),
            MOTHERBOARDSWITHOUTURL("MSI MEG Z390 Golike", "MSI", "E-ATX", "50 699", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Gigabyte Z390 Aorus Xtreme", "Gigabyte", "E-ATX", "82 099", "LGA1151-2", "Z390", "DDR4", "Yes"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Extreme4", "Asrock", "ATX", "14 799", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Phantom Gaming 4", "Asrock", "ATX", "6 399", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Phantom Gaming 4S", "Asrock", "ATX", "7 399", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Phantom Gaming X", "Asrock", "ATX", "7 399", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Phantom Gaming 6", "Asrock", "ATX", "10 499", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Phantom Gaming 7", "Asrock", "ATX", "21 099", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Phantom Gaming 9", "Asrock", "ATX", "18 980", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Phantom Gaming SLI", "Asrock", "ATX", "15 499", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Pro4", "Asrock", "ATX", "13 350", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Steel Legend", "Asrock", "ATX", "9 381", "LGA1151-2", "Z390", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Taichi", "Asrock", "ATX", "23 284", "LGA1151-2", "Z390", "DDR4", "Yes"),
            MOTHERBOARDSWITHOUTURL("Asrock Z390 Taichi Ultimate", "Asrock", "ATX", "16 990", "LGA1151-2", "Z390", "DDR4", "Yes"),
            MOTHERBOARDSWITHOUTURL("Gigabyte B360N GSM", "Gigabyte", "Mini-ITX", "10 168", "LGA1151-2", "B360", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("MSI B360I Gaming Pro AC", "MSI", "Mini-ITX", "7 505", "LGA1151-2", "B360", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asus Prime H310-Plus", "Asus", "ATX", "7 110", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asus Prime H310-Plus Gaming", "Asus", "ATX", "7 379", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Gigabyte H310 D3", "Gigabyte", "ATX", "5 880", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("MSI H310-A Pro", "MSI", "ATX", "4 000", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("MSI H310-F Pro", "MSI", "ATX", "7 800", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock H310CM-DVS", "Asrock", "Micro-ATX", "5 649", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock H310CM-HDV", "Asrock", "Micro-ATX", "5 359", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock H310CM-DGS", "Asrock", "Micro-ATX", "4 760", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock H310CM-HDVP", "Asrock", "Micro-ATX", "4 799", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asus EX-H310M-V3", "Asus", "Micro-ATX", "7 414", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asus Prime H310M-A", "Asus", "Micro-ATX", "4 800", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asus Prime H310M-C", "Asus", "Micro-ATX", "7 035", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asus Prime H310M-D", "Asus", "Micro-ATX", "8 602", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asus Prime H310M-E", "Asus", "Micro-ATX", "7 960", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asus Prime H310M-K", "Asus", "Micro-ATX", "3 600", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asus Prime H310M-Plus Gaming", "Asus", "Micro-ATX", "7 695", "LGA1151-2", "H310", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock H610M-HVS", "Asrock", "Micro-ATX", "7 099", "LGA1700", "H610", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Colorful H610M-K M.2 V20", "Coloful", "Micro-ATX", "7 299", "LGA1700", "H610", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Gigabyte B660M DS3H", "Gigabyte", "Micro-ATX", "8 999", "LGA1700", "B660", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("MSI B660M-A Pro", "MSI", "Micro-ATX", "7 499", "LGA1700", "B660", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asrock B660M-ITX/ac", "Asrock", "Mini-ITX", "9 190", "LGA1700", "B660", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asus Pro Q670M-C-CSM", "Asus", "Micro-ATX", "13 799", "LGA1700", "Q670", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Asus Prime Z690M-Plus", "Asus", "Micro-ATX", "13 999", "LGA1700", "Z690", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("ASUS Prime H410M-E", "Asus", "Micro-ATX", "5 499", "LGA1200", "H410", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("MSI H410M PRO", "MSI", "Micro-ATX", "5 299", "LGA1200", "H410", "DDR4", "No"),
            MOTHERBOARDSWITHOUTURL("Gigabyte H410M H", "Gigabyte", "Micro-ATX", "4 299", "LGA1200", "H410", "DDR4", "No")
        )
    }

    private fun getCPUs(): List<CPUWITHOUTURL> {
        return listOf(
            CPUWITHOUTURL("Intel Core i5-9600KF", "Intel", "Core i5", "8 199", "LGA1151-2"),
            CPUWITHOUTURL("Intel Core i7-13700K", "Intel", "Core i7", "44 999", "LGA1700"),
            CPUWITHOUTURL("Intel Core i7-10700K", "Intel", "Core i7", "27 999", "LGA1200"),
            CPUWITHOUTURL("Intel Core i3-12300", "Intel", "Core i3", "11 599", "LGA1700"),
            CPUWITHOUTURL("Intel Core i9-9900K", "Intel", "Core i9", "36 999", "LGA1151-2"),
            CPUWITHOUTURL("Intel Core i9-12900K", "Intel", "Core i9", "48 999", "LGA1700"),
            CPUWITHOUTURL("Intel Core i5-12600KF", "Intel", "Core i5", "24 499", "LGA1700"),
            CPUWITHOUTURL("Intel Core i5-10600K", "Intel", "Core i5", "18 699", "LGA1200"),
            CPUWITHOUTURL("Intel Core i5-10600KF", "Intel", "Core i5", "19 499", "LGA1200"),
            CPUWITHOUTURL("Intel Core i7-8700K", "Intel", "Core i7", "13 999", "LGA1151-2"),
            CPUWITHOUTURL("Intel Core i5-8600", "Intel", "Core i5", "8 899", "LGA1151-2"),
            CPUWITHOUTURL("Intel Core i5-11400", "Intel", "Core i5", "17 199", "LGA1200"),
            CPUWITHOUTURL("Intel Core i9-12900KF", "Intel", "Core i9", "41 499", "LGA1700"),
            CPUWITHOUTURL("Intel Core i3-9350KF", "Intel", "Core i3", "12 383", "LGA1151-2"),
            CPUWITHOUTURL("Intel Core i5-12600K", "Intel", "Core i5", "25 999", "LGA1700"),
            CPUWITHOUTURL("Intel Core i5-9400F", "Intel", "Core i5", "9 799", "LGA1151-2"),
            CPUWITHOUTURL("Intel Core i5-12400", "Intel", "Core i5", "18 899", "LGA1700"),
            CPUWITHOUTURL("Intel Core i3-10325", "Intel", "Core i3", "10 999", "LGA1200"),
            CPUWITHOUTURL("Intel Core i9-10900K", "Intel", "Core i9", "59 999", "LGA1200"),
            CPUWITHOUTURL("Intel Core i3-9100", "Intel", "Core i3", "10 999", "LGA1151-2"),
            CPUWITHOUTURL("Intel Core i9-10920X", "Intel", "Core i9", "38 999", "LGA2066"),
            CPUWITHOUTURL("Intel Core i7-12700K", "Intel", "Core i7", "35 499", "LGA1700"),
            CPUWITHOUTURL("Intel Core i7-10700KF", "Intel", "Core i7", "25 499", "LGA1200"),
            CPUWITHOUTURL("Intel Core i5-12500", "Intel", "Core i5", "22 199", "LGA1700")
        )
    }

    private fun getGPUs(): List<GPUWITHOUTURL> {
        return listOf(
            GPUWITHOUTURL(
                "MSI GeForce RTX 4090 Ventus 3X OC",
                "MSI",
                "GDDR6X",
                "183 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Palit Geforce RTX 4090 GameRock",
                "Palit",
                "GDDR6X",
                "188 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Palit Geforce RTX 4090 GameRock OC",
                "Palit",
                "GDDR6X",
                "189 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4090 Gaming OC",
                "Gigabyte",
                "GDDR6X",
                "205 799",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Palit Geforce RTX 4090 GameRock OmniBlack",
                "Palit",
                "GDDR6X",
                "197 499",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "MSI GeForce RTX  4090 Suprim X",
                "MSI",
                "GDDR6X",
                "214 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4090 Aero OC",
                "Gigabyte",
                "GDDR6X",
                "199 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "MSI GeForce RTX 4090 Suprim Liquid X",
                "MSI",
                "GDDR6X",
                "216 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Inno3D GeForce RTX 4090 iCHILL Black",
                "Inno3D",
                "GDDR6X",
                "207 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "MSI GeForce RTX 4090 X Trio",
                "MSI",
                "GDDR6X",
                "187 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Asus GeForce RTX 4090 TUF Gaming OC Edition",
                "Asus",
                "GDDR6X",
                "215 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "MSI GeForce RTX 4090 Suprim X Classic",
                "MSI",
                "GDDR6X",
                "198 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Inno3D GeForce RTX 4090 iCHILL X3",
                "Inno3D",
                "GDDR6X",
                "175 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "KFA2 GeForce RTX 4090 HOF",
                "KFA2",
                "GDDR6X",
                "180 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "MSI GeForce RTX 4090 Suprim Classic",
                "MSI",
                "GDDR6X",
                "177 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Inno3D GeForce RTX 4090 iCHILL Frostbite",
                "Inno3D",
                "GDDR6X",
                "179 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Colorful iGame GeForce RTX 4090 Advanced OC-V",
                "Colorful",
                "GDDR6X",
                "173 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "MSI Geforce RTX 4090 Suprim",
                "MSI",
                "GDDR6X",
                "146 499",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4090 Aorus Master",
                "Gigabyte",
                "GDDR6X",
                "181 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4090 Aorus Xtreme",
                "Gigabyte",
                "GDDR6X",
                "155 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "KFA2 GeForce RTX 4090 SG-1-Click OC",
                "KFA2",
                "GDDR6X",
                "139 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4090 Aorus Xtreme Waterforce",
                "Gigabyte",
                "GDDR6X",
                "155 999",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Asus GeForce RTX 4090 ROG Strix OC Edition",
                "Asus",
                "GDDR6X",
                "254 400",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Asus GeForce RTX 4090 ROG Strix White OC Edition",
                "Asus",
                "GDDR6X",
                "176 166",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4090 Windforce",
                "Gigabyte",
                "GDDR6X",
                "190 195",
                "384 bit",
                "24G"
            ),
            GPUWITHOUTURL(
                "MSI GeForce RTX 4080 Suprim X",
                "MSI",
                "GDDR6X",
                "160 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Palit GeForce RTX 4080 GameRock OmniBlack",
                "Palit",
                "GDDR6X",
                "139 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4080 Eagle OC",
                "Gigabyte",
                "GDDR6X",
                "142 499",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4080 Gaming OC",
                "Gigabyte",
                "GDDR6X",
                "146 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "MSI GeForce RTX 4080 Gaming X Trio White",
                "MSI",
                "GDDR6X",
                "145 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Palit GeForce RTX 4080 GameRock",
                "Palit",
                "GDDR6X",
                "134 499",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Palit GeForce RTX 4080 GamingPro",
                "Palit",
                "GDDR6X",
                "137 499",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4080 Aero OC",
                "Gigabyte",
                "GDDR6X",
                "144 499",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4080 Aorus Master",
                "Gigabyte",
                "GDDR6X",
                "165 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4080 Eagle",
                "Gigabyte",
                "GDDR6X",
                "141 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Gigabyte GeForce RTX 4080 Aero",
                "Gigabyte",
                "GDDR6X",
                "141 499",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "MSI GeForce RTX 4080 Gaming X Trio",
                "MSI",
                "GDDR6X",
                "147 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Palit GeForce RTX 4080 JetStream",
                "Palit",
                "GDDR6X",
                "129 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "KFA2 GeForce RTX 4080 SG-1-Click OC",
                "KFA2",
                "GDDR6X",
                "133 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "MSI GeForce RTX 4080 Ventus 3X OC",
                "MSI",
                "GDDR6X",
                "132 499",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Inno3D GeForce RTX 4080 iCHILL Frostbite",
                "Inno3D",
                "GDDR6X",
                "165 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "MSI GeForce RTX 4080 Gaming X Slim White",
                "MSI",
                "GDDR6X",
                "145 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Palit GeForce RTX 4080 GameRock OC",
                "Palit",
                "GDDR6X",
                "139 499",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "Palit GeForce RTX 4080 GamingPro OC",
                "Palit",
                "GDDR6X",
                "135 999",
                "256 bit",
                "16G"
            ),
            GPUWITHOUTURL(
                "MSI GeForce RTX 4080 Suprim",
                "MSI",
                "GDDR6X",
                "147 499",
                "256 bit",
                "16G"
            )
        )
    }



    private fun getPowersupplies(): List<POWERSUPPLIESWITHOUTURL> {
        return listOf(
            POWERSUPPLIESWITHOUTURL("be quiet! System Power 9 500W", "Bronze", "500W", "2 350"),
            POWERSUPPLIESWITHOUTURL("Corsair CV550", "Bronze", "550W", "2 699"),
            POWERSUPPLIESWITHOUTURL("DeepCool DA500", "Bronze", "500W", "2 999"),
            POWERSUPPLIESWITHOUTURL("be quiet! System Power 9 600W", "Bronze", "600W", "3 099"),
            POWERSUPPLIESWITHOUTURL("ExeGate 550PPH", "Bronze", "500W", "3 499"),
            POWERSUPPLIESWITHOUTURL("Montech Beta 550", "Bronze", "550W", "3 599"),
            POWERSUPPLIESWITHOUTURL("StPlayer DR Premium 5.0", "Bronze", "500W", "3 799"),
            POWERSUPPLIESWITHOUTURL("be quiet! System Power 9 700W", "Bronze", "700W", "3 799"),
            POWERSUPPLIESWITHOUTURL(
                "Xilence Performance A+ III Series XN082",
                "Bronze",
                "550W",
                "3 899"
            ),
            POWERSUPPLIESWITHOUTURL("Chieftec Volta VPS-700S", "Bronze", "700W", "3 999"),
            POWERSUPPLIESWITHOUTURL("Cougar VTE500", "Bronze", "500W", "4 099"),
            POWERSUPPLIESWITHOUTURL("Aerocool KCAS Plus 600W", "Bronze", "600W", "4 499"),
            POWERSUPPLIESWITHOUTURL("Corsair CX550F RGB White", "Bronze", "550W", "5 999"),
            POWERSUPPLIESWITHOUTURL("Corsair CX650F RGB", "Bronze", "650W", "6 099"),
            POWERSUPPLIESWITHOUTURL("Aerocool Aero Bronze 750W", "Bronze", "750W", "6 199"),
            POWERSUPPLIESWITHOUTURL("Cooler Master MWE Bronze 600W V2", "Bronze", "600W", "6 199"),
            POWERSUPPLIESWITHOUTURL("Deepcool PK750D", "Bronze", "750W", "6 199"),
            POWERSUPPLIESWITHOUTURL("Gigabyte P650B", "Bronze", "650W", "6 299"),
            POWERSUPPLIESWITHOUTURL("Corsair CX750F RGB", "Bronze", "750W", "6 399"),
            POWERSUPPLIESWITHOUTURL("Thermaltake Smart BX1 RGB 750W", "Bronze", "750W", "6 599"),
            POWERSUPPLIESWITHOUTURL("A-Data XPG Pylon Bronze 750W", "Bronze", "750W", "6 699"),
            POWERSUPPLIESWITHOUTURL("Asus TUF-Gaming-650B", "Bronze", "650W", "10 199"),
            POWERSUPPLIESWITHOUTURL("Chieftec Proton 1000W", "Bronze", "1000W", "10 999"),
            POWERSUPPLIESWITHOUTURL("Thermaltake Smart PRO RGB 850W", "Bronze", "850W", "11 299"),
            POWERSUPPLIESWITHOUTURL(
                "Xilence Performance A+ III Series XN089",
                "Bronze",
                "850W",
                "13 999"
            ),
            POWERSUPPLIESWITHOUTURL("Asus TUF-Gaming-750W", "Bronze", "750W", "15 299"),
            POWERSUPPLIESWITHOUTURL("Chieftec Silicon 850W", "Bronze", "850W", "15 699"),
            POWERSUPPLIESWITHOUTURL("Chieftec Silicon 1000W", "Bronze", "1000W", "18 899"),
            POWERSUPPLIESWITHOUTURL("Corsair CV650", "Bronze", "650W", "4 199"),
            POWERSUPPLIESWITHOUTURL("Zalman GigaMax (GVII) 750W", "Bronze", "750W", "5 699"),
            POWERSUPPLIESWITHOUTURL("ExeGate ServerPRO 600PPH-SE", "Bronze", "600W", "5 899"),
            POWERSUPPLIESWITHOUTURL("Crown Cm-PS500W Pro", "Silver", "500W", "5 499"),
            POWERSUPPLIESWITHOUTURL("ExeGate M650", "Silver", "650W", "6 699"),
            POWERSUPPLIESWITHOUTURL("ExeGate M700", "Silver", "700W", "6 899"),
            POWERSUPPLIESWITHOUTURL("ExeGate M800", "Silver", "800W", "7 099"),
            POWERSUPPLIESWITHOUTURL("ExeGate M750", "Silver", "750W", "7 299"),
            POWERSUPPLIESWITHOUTURL("ExeGate M850", "Silver", "850W", "8 099"),
            POWERSUPPLIESWITHOUTURL("Chieftec Smart 500W", "Standard", "500W", "2 450"),
            POWERSUPPLIESWITHOUTURL("Chieftec Value 500W", "Standard", "500W", "2 899"),
            POWERSUPPLIESWITHOUTURL("Deepcool DN500", "Standard", "500W", "2 899"),
            POWERSUPPLIESWITHOUTURL("Powerman 500W", "Standard", "500W", "3 199"),
            POWERSUPPLIESWITHOUTURL("Pangu Multi-Core King S550 550W", "Standard", "550W", "3 299"),
            POWERSUPPLIESWITHOUTURL("Aerocool Cylon 500W", "Standard", "500W", "3 499"),
            POWERSUPPLIESWITHOUTURL("Aerocool Cylon 600W", "Standard", "600W", "3 999"),
            POWERSUPPLIESWITHOUTURL("Thermaltake TR2 S 600W", "Standard", "600W", "4 799")
        )


    }

    private fun getRAMs(): List<RAMWITHOUTURL> {
        return listOf(
            RAMWITHOUTURL("ADATA 4G", "399.0", "DDR4", "4G"),
            RAMWITHOUTURL("Kingston ValueRAM 4G", "499.0", "DDR4", "4G"),
            RAMWITHOUTURL("Samsung 8G", "599.0", "DDR4", "8G"),
            RAMWITHOUTURL("AMD Radeon R7 Perfomance Series 4G", "799.0", "DDR4", "4G"),
            RAMWITHOUTURL("Crucial 4G", "899.0", "DDR4", "4G"),
            RAMWITHOUTURL("QUMO 8G", "1 099", "DDR4", "8G"),
            RAMWITHOUTURL("Apacer 16G", "1 199", "DDR4", "16G"),
            RAMWITHOUTURL("Crucial 8G", "1 199", "DDR4", "8G"),
            RAMWITHOUTURL("GeIL Orion 8G", "1 199", "DDR4", "8G"),
            RAMWITHOUTURL("Hynix 8G", "1 199", "DDR4", "8G"),
            RAMWITHOUTURL("Patriot Signature 4G", "1 199", "DDR4", "4G"),
            RAMWITHOUTURL("ADATA XPG Spectrix 8G", "1 999", "DDR4", "8G"),
            RAMWITHOUTURL("Kingston FURY Beast RGB 8G", "1 999", "DDR4", "8G"),
            RAMWITHOUTURL("Silicon Power Xpower Zenith 8G", "1 999", "DDR4", "8G"),
            RAMWITHOUTURL("AMD Radeon R9 Gameer Series 8G", "2 199", "DDR4", "8G"),
            RAMWITHOUTURL("Patriot Viper Elite II 4G", "2 199", "DDR4", "4G"),
            RAMWITHOUTURL("Patriot Viper Steel 8G", "2 199", "DDR4", "8G"),
            RAMWITHOUTURL("QUMO 8G", "2 199", "DDR4", "8G"),
            RAMWITHOUTURL("Kingston FURY Beast Black 8G", "2 250", "DDR4", "8G"),
            RAMWITHOUTURL("ADATA XPG Gammix D10 8G", "2 350", "DDR4", "8G"),
            RAMWITHOUTURL("Apacer 16G", "2 999", "DDR4", "16G"),
            RAMWITHOUTURL("Foxline 16G", "2 999", "DDR4", "16G"),
            RAMWITHOUTURL("GeIL Orion 16G", "2 999", "DDR4", "16G"),
            RAMWITHOUTURL("Hynix 16G", "2 999", "DDR4", "16G"),
            RAMWITHOUTURL("ADATAA XPG Gammix D20 32G", "3 099", "DDR4", "32G"),
            RAMWITHOUTURL("Hynix 8G", "1 499", "DDR5", "8G"),
            RAMWITHOUTURL("AMD Radeon R5 8G", "1 999", "DDR5", "8G"),
            RAMWITHOUTURL("ADATA 8G", "2 099", "DDR5", "8G"),
            RAMWITHOUTURL("Netac Basic 8G", "2 599", "DDR5", "8G"),
            RAMWITHOUTURL("Apacer NOX 8G", "2 699", "DDR5", "8G"),
            RAMWITHOUTURL("Patriot Signature Line 8G", "2 699", "DDR5", "8G"),
            RAMWITHOUTURL("ADATA XPG Lancer 8G", "2 799", "DDR5", "8G"),
            RAMWITHOUTURL("Samsung 8G", "2 999", "DDR5", "8G"),
            RAMWITHOUTURL("Kingston ValueRAM 8G", "3 399", "DDR5", "8G"),
            RAMWITHOUTURL("ADATA XPG Caster RGB 16G", "6 999", "DDR5", "16G"),
            RAMWITHOUTURL("ADATA XPG Lancer Blade 16G", "6 999", "DDR5", "16G"),
            RAMWITHOUTURL("Kingston Fury Beast AMD RGB White 16G", "6 999", "DDR5", "16G"),
            RAMWITHOUTURL("ADATA XPG Lancer 16G", "7 099", "DDR5", "16G"),
            RAMWITHOUTURL("ADATA XPG Lancer RGB 16G", "7 299", "DDR5", "16G"),
            RAMWITHOUTURL("Patriot Viper Venom 8G", "7 299", "DDR5", "8G"),
            RAMWITHOUTURL("Apacer Panther 32G", "9 899", "DDR5", "32G"),
            RAMWITHOUTURL("Kinston FURY Beast White 32G", "9 999", "DDR5", "32G"),
            RAMWITHOUTURL("Silicon Power Xpower Zenith 16G", "9 999", "DDR5", "16G"),
            RAMWITHOUTURL("ADATA XPG Lancer Blade 16G", "10 199", "DDR5", "16G"),
            RAMWITHOUTURL("ADATA 32G", "10 199", "DDR5", "32G")
        )

    }

    private fun getSSDs(): List<SSDWITHOUTURL> {
        return listOf(
            SSDWITHOUTURL("SATA Kingston A400 480G", "3 399", "N/A", "480G"),
            SSDWITHOUTURL("SATA Samsung 870 EVO 1000G", "8 999", "N/A", "1000G"),
            SSDWITHOUTURL("SATA Kingston A400 240G", "2 399", "N/A", "240G"),
            SSDWITHOUTURL("SATA Samsung 870 EVO  500G", "6 399", "N/A", "500G"),
            SSDWITHOUTURL("SATA Kingston A400 960G", "5 999", "N/A", "960G"),
            SSDWITHOUTURL("SATA Apacer AS350 Panther 512G", "3 699", "N/A", "512G"),
            SSDWITHOUTURL("SATA Samsung 870 QVO 1000G", "7 899", "N/A", "1000G"),
            SSDWITHOUTURL("SATA Samsung 870 EVO 250G", "5 199", "N/A", "250G"),
            SSDWITHOUTURL("SATA ADATA SU650 240G", "2 199", "N/A", "240G"),
            SSDWITHOUTURL("SATA ADATA SU650 480G", "3 299", "N/A", "480G"),
            SSDWITHOUTURL("SATA Apacer AS350 Panther 1000G", "5 999", "N/A", "1000G"),
            SSDWITHOUTURL("SATA Samsung 870 QVO 2000G", "12 999", "N/A", "2000G"),
            SSDWITHOUTURL("SATA Samsung 870 EVO 500G", "6 499", "N/A", "500G"),
            SSDWITHOUTURL("SATA Apacer AS350 Panther 256G", "2 199", "N/A", "256G"),
            SSDWITHOUTURL("SATA ExeGate NextPro 480G", "3 299", "N/A", "480G"),
            SSDWITHOUTURL("SATA ExeGate NextPro 120G", "1 399", "N/A", "120G"),
            SSDWITHOUTURL("SATA Transcend SSD250N 2000G", "30 799", "N/A", "2000G"),
            SSDWITHOUTURL("SATA AGI AI238 1000G", "4 699", "N/A", "1000G"),
            SSDWITHOUTURL("SATA AGI AI238 500G", "2 399", "N/A", "500G"),
            SSDWITHOUTURL("SATA AGI AI138 256G", "1 599", "N/A", "256G"),
            SSDWITHOUTURL("SATA WD Blue SA510 500G", "5 099", "N/A", "500G"),
            SSDWITHOUTURL("SATA Kingston KC600 2048G", "16 499", "N/A", "2048G"),
            SSDWITHOUTURL("SATA AMD Radeon R5 Series 256G", "1 999", "N/A", "256G"),
            SSDWITHOUTURL("SATA ADATA SU635 240G", "2 699", "N/A", "240G"),
            SSDWITHOUTURL("SATA WD Red SA500 500G", "6 899", "N/A", "500G"),
            SSDWITHOUTURL("M.2 ARDOR Gaming Ally AL1288 1024G", "5 499", "NVMe", "1024G"),
            SSDWITHOUTURL("M.2 ADATA XPG Gammix S11 Pro 1000G", "6 299", "NVMe", "1000G"),
            SSDWITHOUTURL("M.2 Samsung 980 Pro 1000G", "11 999", "NVMe", "1000G"),
            SSDWITHOUTURL("M.2 Samsung 970 EVO Plus 1000G", "9 399", "NVMe", "1000G"),
            SSDWITHOUTURL("M.2 Samsung 980 1000G", "9 499", "NVMe", "1000G"),
            SSDWITHOUTURL("M.2 ARDOR Gaming Ally Al1284 512G", "3 299", "NVMe", "512G"),
            SSDWITHOUTURL("M.2 Samsung 970 EVO Plus 500G", "5 999", "NVMe", "500G"),
            SSDWITHOUTURL("M.2  ADATA Legend 960 Max 2000G", "13 999", "NVMe", "2000G"),
            SSDWITHOUTURL("M.2 Samsung 970 EVO Plus 2000G", "18 299", "NVMe", "2000G"),
            SSDWITHOUTURL("M.2 Samsung 990 Pro 1000G", "13 999", "NVMe", "1000G"),
            SSDWITHOUTURL("M.2 Apacer AS2280P4 480G", "3 599", "NVMe", "480G"),
            SSDWITHOUTURL("M.2 HP EX900 1000G", "5 999", "NVMe", "1000G"),
            SSDWITHOUTURL("M.2 Apacer AS2280Q4 1000G", "6 799", "NVMe", "1000G"),
            SSDWITHOUTURL("M.2 MSI Spatium M460 1000G", "8 899", "NVMe", "1000G"),
            SSDWITHOUTURL("M.2 Silicon Power UD85 2000G", "11 499", "NVMe", "2000G"),
            SSDWITHOUTURL("M.2 Gigabyte Aorus Gen4 5000E 500G", "6 199", "NVMe", "500G"),
            SSDWITHOUTURL("M.2 WD Green SN350 1000G", "5 999", "NVMe", "1000G"),
            SSDWITHOUTURL("M.2 ADATA XPG SX6000 Lite 128G", "1 599", "NVMe", "128G"),
            SSDWITHOUTURL("M.2 Apacer AS2280P4 512G", "3 999", "NVMe", "512G"),
            SSDWITHOUTURL("M.2 WD Black SN750 SE 500G", "6 699", "NVMe", "500G")
        )

    }

    private fun getCpucoolers(): List<CPUCOOLERWITHOUTURL> {
        return listOf(
            CPUCOOLERWITHOUTURL("Deepcool Gammaxx 300", "1 299"),
            CPUCOOLERWITHOUTURL("Deepcool AK629", "6 999"),
            CPUCOOLERWITHOUTURL("ID-Cooling SE-224-XTS ARGB", "2 899"),
            CPUCOOLERWITHOUTURL("Deepcool Gammax 420 V2 Blue", "2 450"),
            CPUCOOLERWITHOUTURL("ID-Cooling SE-224-XTS", "2 599"),
            CPUCOOLERWITHOUTURL("Deepcool AG620 BK ARGB", "6 299"),
            CPUCOOLERWITHOUTURL("Deepcool Gammaxx 300B", "1 699"),
            CPUCOOLERWITHOUTURL("Deepcool AK400", "2 450"),
            CPUCOOLERWITHOUTURL("ID-Cooling SE-206-XT", "3 199"),
            CPUCOOLERWITHOUTURL("Deepcool Gamma Archer", "899.0"),
            CPUCOOLERWITHOUTURL("ID-Cooling SE-224-XTS", "2 699"),
            CPUCOOLERWITHOUTURL("Deepcool AG300 MARRS", "1 399"),
            CPUCOOLERWITHOUTURL("Deepcool Gammaxx GTE V2", "2 099"),
            CPUCOOLERWITHOUTURL("be quiet! Dark Rock Pro 4", "14 499"),
            CPUCOOLERWITHOUTURL("Deepcool AK400 WH", "5 999"),
            CPUCOOLERWITHOUTURL("AeroCool Rime 4 ARGB", "3 299"),
            CPUCOOLERWITHOUTURL("Cooler Master Hyper 212 Spectrum", "3 299"),
            CPUCOOLERWITHOUTURL("be quiet! Shadow Rock 3", "6 699"),
            CPUCOOLERWITHOUTURL("be quiet! Pure Rock 2", "5 399"),
            CPUCOOLERWITHOUTURL("Zalman CNPS4X", "2 350"),
            CPUCOOLERWITHOUTURL("Thermaltake Toughair 110", "3 699"),
            CPUCOOLERWITHOUTURL("Zalman CNPS9X Performa", "2 999"),
            CPUCOOLERWITHOUTURL("Zalman CNPS10X Optima II_Black", "3 299"),
            CPUCOOLERWITHOUTURL("Zalman CNPS10X Optima II_White", "3 299"),
            CPUCOOLERWITHOUTURL("Thermaltake Toughhair 310", "3 199"),
            CPUCOOLERWITHOUTURL("AeroCool Rave 3 FRGB", "2 099"),
            CPUCOOLERWITHOUTURL("Zalman CNPS9X Performa ARGB", "3 299"),
            CPUCOOLERWITHOUTURL("Cooler Master MasterAir MA610P ARGB", "5 999"),
            CPUCOOLERWITHOUTURL("Deepcool AK500 Digital", "7 499"),
            CPUCOOLERWITHOUTURL("Zalman CNPS20X", "5 399"),
            CPUCOOLERWITHOUTURL("Thermalright Silver Arrow IB-E Extreme Rev. B", "11 999"),
            CPUCOOLERWITHOUTURL("Cooler Master I70C", "1 599"),
            CPUCOOLERWITHOUTURL("Cougar Forza 50", "3 099"),
            CPUCOOLERWITHOUTURL("Artic Cooling Freezer 34 eSports DUO", "5 599"),
            CPUCOOLERWITHOUTURL("Zalman CNPS 9X Optima RGB", "2 250"),
            CPUCOOLERWITHOUTURL("Cooler Master Hyper T200", "1 699"),
            CPUCOOLERWITHOUTURL("PentaWave Z06D", "9 299"),
            CPUCOOLERWITHOUTURL("Cooler Master I30", "799.0"),
            CPUCOOLERWITHOUTURL("AeroColl Raven 4 FRGB PWM 4P", "2 250"),
            CPUCOOLERWITHOUTURL("Thermalright Ultra-120 EX Rev.4", "6 999"),
            CPUCOOLERWITHOUTURL("Iceberg Thermal IceSLEET G4 Midnight", "7 499"),
            CPUCOOLERWITHOUTURL("be quiet! Pure Rock 2 FX", "7 999"),
            CPUCOOLERWITHOUTURL("Cooler Master Hyper 212 Spectrum V2", "2 750"),
            CPUCOOLERWITHOUTURL("Cooler Master Hyper 212X", "3 699"),
            CPUCOOLERWITHOUTURL("Thermalright SI-100", "5 399")

        )

    }

    private fun getCorpus(): List<CORPUSWITHOUTURL> {
        return listOf(
            CORPUSWITHOUTURL("Сougar Duoface Pro RGB", "8 199"),
            CORPUSWITHOUTURL("ARDOR Gaming Rare M2 ARGB", "5 999"),
            CORPUSWITHOUTURL("Cougar Duoface Pro RGB White", "8 599"),
            CORPUSWITHOUTURL("ARDOR Gaming Rare Minicase MS1", "5 499"),
            CORPUSWITHOUTURL("Cougar Duoface RGB White", "5 999"),
            CORPUSWITHOUTURL("ARDOR Gaming Rare Minicase", "3 499"),
            CORPUSWITHOUTURL("Lian Li Lancool III", "13 699"),
            CORPUSWITHOUTURL("Cougar MX330-F", "5 499"),
            CORPUSWITHOUTURL("ARDOR Gaming Rare Minicase MS2 WG", "3 399"),
            CORPUSWITHOUTURL("Zalman i3 Edge", "5 199"),
            CORPUSWITHOUTURL("Deepcool Matrexx 30", "3 299"),
            CORPUSWITHOUTURL("Deepcool CC560 WH", "5 399"),
            CORPUSWITHOUTURL("Deepcool CK560", "7 499"),
            CORPUSWITHOUTURL("Zalman N4 Rev.1", "5 399"),
            CORPUSWITHOUTURL("AeroCool Cylon Mini", "3 099"),
            CORPUSWITHOUTURL("ARDOR Gaming C305 V2", "6 399"),
            CORPUSWITHOUTURL("Montech X3 Glass", "5 499"),
            CORPUSWITHOUTURL("AeroCool Cylon", "3 399"),
            CORPUSWITHOUTURL("DeepCool CC360 WH ARGB", "4 199"),
            CORPUSWITHOUTURL("Montech SKY TWO", "8 699"),
            CORPUSWITHOUTURL("DeepCool CC360 ARGB", "4 899"),
            CORPUSWITHOUTURL("ARDOR Gaming Rare Minicase MS3 Mesh WG ARGB", "3 999"),
            CORPUSWITHOUTURL("AeroCool Cylon", "3 499"),
            CORPUSWITHOUTURL("AeroCool CS-1103", "2 899"),
            CORPUSWITHOUTURL("Lian Li PC-011 Dynamic XL ROG Certify", "20 999"),
            CORPUSWITHOUTURL("DeepCool Matrexx 50 Mesh 4FS", "6 299"),
            CORPUSWITHOUTURL("Montech Air 903 Max", "7 999"),
            CORPUSWITHOUTURL("Zalman i3", "5 599"),
            CORPUSWITHOUTURL("Deepcool Matrexx 55 Mesh ADD-RGB 4F", "6 599"),
            CORPUSWITHOUTURL("AeroCool Aero One Mini Frost", "5 999"),
            CORPUSWITHOUTURL("Lian Li Lancool II Mesh Snow edition", "9 999"),
            CORPUSWITHOUTURL("ADATA XPG Valor Mesh C", "7 299"),
            CORPUSWITHOUTURL("MSI Mag Force 111R", "4 399"),
            CORPUSWITHOUTURL("Cougar Archon 2 Mesh RGB", "4 599"),
            CORPUSWITHOUTURL("MSI Mag Force 112R", "6 899"),
            CORPUSWITHOUTURL("Deepcool CK500", "5 299"),
            CORPUSWITHOUTURL("Thermaltake Core X71 TG", "18 999"),
            CORPUSWITHOUTURL("AeroCool Aero One Mini", "4 499"),
            CORPUSWITHOUTURL("Thermaltake View 51 Tempered Glass ARGB Edition", "18 499"),
            CORPUSWITHOUTURL("Cougar MX330-G Air", "5 199"),
            CORPUSWITHOUTURL("Zalman S4", "4 199"),
            CORPUSWITHOUTURL("Cougar DarkBlader-S", "11 499"),
            CORPUSWITHOUTURL("Cougar Panzer EVO RGB", "19 999"),
            CORPUSWITHOUTURL("DeepCool CH560 Digital WH", "8 999"),
            CORPUSWITHOUTURL("AeroCool Tor Pro", "11 399")
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buildDatabase = BuildDatabase.getInstance(requireContext())

        // После выбора компонентов и нажатия кнопки "Сохранить"
        val saveButton: Button =
            view.findViewById(R.id.selectSaveConfButton)  // Предположим, что у вас есть кнопка "Сохранить"
        saveButton.setOnClickListener {
            val buildToSave = BuildEntity(
                name1 = selectedMotherboard?.name ?: "",  // Используем оператор Элвиса, чтобы вернуть пустую строку, если selectedMotherboard?.name равен null
                motherboard1 = selectedMotherboard,
                cpu1 = selectedCpu,
                gpu1 = selectedGpu,
                powersupply1 = selectedPowersupplies,
                ram1 = selectedRAM,
                ssd1 = selectedSSD,
                cpucooler1 = selectedCpucooler,
                corpus1 = selectedCorpus
            )

            // Сохранение в базу данных
            GlobalScope.launch {
                try {
                    BuildDatabase.getInstance(requireContext()).buildDao().insertBuild(buildToSave)
                    Log.d("BuildingFragment", "Сборка успешно сохранена")
                } catch (e: Exception) {
                    Log.e("BuildingFragment", "Ошибка при сохранении сборки", e)
                }
            }
        }
    }
}