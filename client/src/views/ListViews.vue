<script setup lang="ts">
import ITable from '@/components/table/ITable.vue'
</script>
<template>
  <section class="container text-center m-6">
    <h2 class="t-5">Listado de empleados</h2>
    <ITable />
  </section>
</template>

<style scoped>
section {
  max-width: 1200px;
  margin: 0 auto;
}

@media (max-width: 768px) {
  section {
    width: 100%;
  }
}

h2 {
  font-size: 2rem;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th,
td {
  padding: 10px;
  border: 1px solid #ccc;
}
</style>
