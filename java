<!-- JavaScript DataTable -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

<!-- JavaScript DataTable bundle -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>

<!-- DataTable Responsive -->
<script src="https://cdn.datatables.net/responsive/2.2.9/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.9/js/responsive.bootstrap5.min.js"></script>

<!-- DataTable Button -->
<script src="https://cdn.datatables.net/buttons/1.7.1/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.bootstrap5.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.print.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.colVis.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/1.11.3/dataRender/hyperLink.js"></script>
<script src="https://cdn.datatables.net/plug-ins/1.11.3/dataRender/percentageBars.js"></script>

<script>
      google.script.run.withSuccessHandler(showData).getData2();
      function showData(data) {
        $(document).ready(function () {
          var dataSet = data;
          var head = [];
          data[0].forEach(function (e) {
            head.push({ sTitle: e });
          });
          $("#example2").DataTable({
            data: dataSet.slice(1),
            columns: head,
            responsive: true,
            language: {
              url: "https://cdn.datatables.net/plug-ins/1.11.3/i18n/th.json",
            },
      columnDefs: [ {
      targets: 3,
      render: $.fn.dataTable.render.hyperLink( 'Download', 'popup' )
    } ],

        lengthMenu: [
            [ 5, 15, 25, 50, -1 ],
            [ '5 baris', '15 baris', '25 baris', '50 baris', 'semua' ]
        ],
      
      order: [[0, "desc"], [2, "asc"], ],
      responsive: true,
  
      dom: 'Bfrtip', //
      buttons: [
        {extend: 'copy',text: 'Copy',},
        {extend: 'csv',text: 'CSV',charset: 'utf-8',filename: 'Search Report',bom: 'true',}, //
        {extend: 'excel',text: 'Excel'}, 
        {extend: 'pdf',text: 'PDF',exportOptions: {columns: ':visible'}, // PDF                
          customize: function (doc) {   
          doc.defaultStyle.fontSize = 10;}},
        {extend: 'print',text: 'Print'},
        ],

       
      });
    });
  }
</script>
