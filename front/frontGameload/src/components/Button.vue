<template>
  <button class="button">{{ title }}</button>
</template>

<script>
export default {
  name: 'Button',
    props: {
      title: String
    }
}
</script>

<style>
.button{
  border: none;
  border-radius: 2px;
  color: var(--secundary-color);
  font-weight: 700;
  font-size: 1em;
  margin-right: 0;
  padding: 8px 12px;
  text-transform: uppercase;
  cursor: pointer;
}
.regular {
  background:var(--light-blue);
}
.regular:hover {
  background: var(--palette-pink)
}
.optional {
  background:var(--palette-pink);
}
.optional:hover {
  background: var(--light-blue)
}
</style>